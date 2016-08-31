FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${KERNEL_VERSION}:"

SRC_URI = "git://github.com/ExorEmbedded/linux-us02.git;protocol=git;branch=4.1-LTS_us02_etop"
SRC_URI[md5sum] = "7094df7dedb134fa41ee6679a34de190"
SRCREV = "f1c72756b1648f6e4049ac443e30d92cb6952968"

SRC_URI += "file://defconfig"

COMPATIBLE_MACHINE = "(usom02)"

include linux.inc

PR = "r1"

B = "${S}"

do_install_prepend() {
   mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel
   mkdir -p "${D}/lib/modules/${KERNEL_VERSION}"
   touch "${D}/lib/modules/${KERNEL_VERSION}/build"
   mkdir -p "${D}/lib/modules/${KERNEL_VERSION}"
   touch "${D}/lib/modules/${KERNEL_VERSION}/source"
}

#include linux.inc

INSANE_SKIP_linux += "installed-vs-shipped" 

KERNEL_DEVICETREE = "usom_us02kit.dtb"
DTB_TARGET = "socfpga.dtb"

KERNEL_VERSION = "4.1"

