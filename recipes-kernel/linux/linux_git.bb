DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRCNAME = "kernel"
SRC_URI = "git://github.com/ExorEmbedded/linux-us02.git;protocol=git"
SRC_URI[md5sum] = "7094df7dedb134fa41ee6679a34de190"
SCRBRANCH = "3.10-LTS"
SRCREV = "afbe937ce2c9f0acaa306661e0fbd9acaa88167b"

KERNEL_RELEASE = "3.10"
PV = "3.10"
PR = "r10"
S = "${WORKDIR}/git"

KERNEL_IMAGETYPE = "zImage"
KERNEL_EXTRA_ARGS = "dtbs"

COMPATIBLE_MACHINE = "(usom02)"

KERNEL_DEVICETREE_usom02 = "socfpga_cyclone5.dtb"

inherit kernel

DTB_PATH = "${B}/arch/${ARCH}/boot/dts/"

do_configure() {
    if [ "x${KERNEL_MACHINE}" != "x" ]; then
        oe_runmake ${KERNEL_MACHINE}_defconfig ARCH=$ARCH
    else
        oe_runmake defconfig ARCH=$ARCH
    fi
}

do_install_append() {
    install -d "${D}/boot"
    for DTB in ${KERNEL_DEVICETREE}; do
        install -m 0644 ${DTB_PATH}/${DTB} "${D}/boot"
    done
}

do_deploy() {
    install -d "${DEPLOYDIR}"
    install -m 0644 "${B}/${KERNEL_OUTPUT}" "${DEPLOYDIR}"
    for DTB in ${KERNEL_DEVICETREE}; do
        install -m 0644 ${DTB_PATH}/${DTB} "${DEPLOYDIR}"
    done

    cd "${DEPLOYDIR}"
    mv ${KERNEL_DEVICETREE} socfpga.dtb
    tar czvf "us02-kernel.tar.gz" "${KERNEL_IMAGETYPE}" *.dtb
    #ln -sf ${VERSION_HUMAN}.tar.gz ${VERSION_HUMAN_NOVER}.tar.gz

    rm "${KERNEL_IMAGETYPE}"
    rm *.dtb
}

FILES_kernel-image += "/boot/*.dtb"
