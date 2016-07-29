FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${KERNEL_VERSION}:"

SRC_URI = "git://github.com/ExorEmbedded/linux-us01.git;protocol=git;branch=ti-linux-3.12.y"
SRC_URI[md5sum] = "7094df7dedb134fa41ee6679a34de190"
SRCREV = "f1c7654a9832b4f362b38456f1c349a2c1a9cee4"

COMPATIBLE_MACHINE = "(usom01)"

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

KERNEL_DEVICETREE = "usom_eco.dtb"

KERNEL_VERSION = "3.12.17"
