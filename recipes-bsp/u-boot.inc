DESCRIPTION = "U-Boot - the Universal Boot Loader"
HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

inherit uboot-config deploy

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

# Allow setting an additional version string that will be picked up by the
# u-boot build system and appended to the u-boot version.  If the .scmversion
# file already exists it will not be overwritten.
UBOOT_LOCALVERSION ?= ""

UBOOT_SUFFIX = "img"
UBOOT_IMAGE = "u-boot.${UBOOT_SUFFIX}"
UBOOT_MAKE_TARGET = "all"

SPL_SUFFIX = "hex"
SPL_IMAGE = "u-boot-spl.${SPL_SUFFIX}"

do_compile () {
	if [ "${@base_contains('DISTRO_FEATURES', 'ld-is-gold', 'ld-is-gold', '', d)}" = "ld-is-gold" ] ; then
		sed -i 's/$(CROSS_COMPILE)ld$/$(CROSS_COMPILE)ld.bfd/g' config.mk
	fi

	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS

	if [ ! -e ${B}/.scmversion -a ! -e ${S}/.scmversion ]
	then
		echo ${UBOOT_LOCALVERSION} > ${B}/.scmversion
		echo ${UBOOT_LOCALVERSION} > ${S}/.scmversion
	fi

	oe_runmake ${UBOOT_MACHINE}
	oe_runmake ${UBOOT_MAKE_TARGET}

        cd ${S}/spl
        $(CROSS_COMPILE)objcopy -O ihex --adjust-vma -0xc0000000 u-boot-spl ${SPL_IMAGE}
}

do_deploy () {
    install -d ${DEPLOYDIR}

    install ${S}/${UBOOT_IMAGE} ${DEPLOYDIR}
    install ${S}/spl/${SPL_IMAGE} ${DEPLOYDIR}

    cd ${DEPLOYDIR}
    tar czvf us02-uboot.tar.gz ${UBOOT_IMAGE}
    rm ${UBOOT_IMAGE}

    tar czvf us02-uboot-spl.tar.gz ${SPL_IMAGE}
    rm ${SPL_IMAGE}
}

addtask deploy before do_build after do_compile
