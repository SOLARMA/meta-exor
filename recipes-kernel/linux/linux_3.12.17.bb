DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRC_URI = "git://github.com/ExorEmbedded/linux-us01.git;protocol=git;branch=ti-linux-3.12.y"
SRC_URI[md5sum] = "7094df7dedb134fa41ee6679a34de190"
SRCREV = "5a9729b117cff28aa5a38840b7d0d6f82fa2b25c"

LINUX_VERSION = "3.12.17"

COMPATIBLE_MACHINE = "(usom01)"

KERNEL_DEVICETREE = "\
        usom_eco.dtb \
        usom_etop5xx.dtb \
        usom_plcm07.dtb \
        usom_etop705.dtb \
"

COMPATIBLE_MACHINE = "(usom01)"

PV = "${LINUX_VERSION}+git${SRCPV}"

KERNEL_IMAGETYPE = "zImage"
KERNEL_EXTRA_ARGS = "dtbs"

inherit kernel

S = "${WORKDIR}/git"
B = "${S}"

DTB_PATH = "${B}/arch/${ARCH}/boot/dts/"

do_kernel_configme() {
    cp "${S}/arch/${ARCH}/configs/${KERNEL_MACHINE}_defconfig" "${B}/.config"
}

do_install_append() {
    install -d "${D}/boot"
    for DTB in ${KERNEL_DEVICETREE}; do
        install -m 0644 ${DTB_PATH}/${DTB} "${D}/boot"
    done
}

do_deploy_append() {
   install -d "${DEPLOYDIR}"
   install -m 0644 "${B}/${KERNEL_OUTPUT}" "${DEPLOYDIR}"
   for DTB in ${KERNEL_DEVICETREE}; do
      install -m 0644 "${DTB_PATH}/${DTB}" "${DEPLOYDIR}"
   done

   cd "${DEPLOYDIR}"

   if [ -n "${DTB_TARGET}" ] ; then
                mv ${KERNEL_DEVICETREE} ${DTB_TARGET}
                tar czvf "${MACHINE}-kernel-${KERNEL_VERSION}-${DATETIME}.tar.gz" "${KERNEL_IMAGETYPE}" ${DTB_TARGET}
   else
                tar czvf "${MACHINE}-kernel-${KERNEL_VERSION}-${DATETIME}.tar.gz" "${KERNEL_IMAGETYPE}" ${KERNEL_DEVICETREE}
   fi

   ln -sf "${MACHINE}-kernel-${KERNEL_VERSION}-${DATETIME}.tar.gz" ${MACHINE}-kernel.tar.gz

   rm -rf  ${KERNEL_IMAGETYPE}*
   rm -rf *.dtb
}

do_deploy[vardepsexclude] = "DATETIME"

PACKAGES_EXCLUDE = "kernel-vmlinux"
FILES_kernel-image += "/boot/*.dtb"

addtask kernel_configme before do_configure after do_patch

python () {
    # Avoid race conditions with do_unpack_and_patch task form the archiver class by specifying the correct order
    if bb.data.inherits_class('archiver', d):
        bb.build.addtask('do_kernel_configme', 'do_configure', 'do_unpack_and_patch', d)
}
