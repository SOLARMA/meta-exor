FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${KERNEL_VERSION}:"

SRC_URI = "git://github.com/ExorEmbedded/linux-us02.git;protocol=git;branch=3.10-LTS;nocheckout=1"
SRC_URI[md5sum] = "7094df7dedb134fa41ee6679a34de190"
SRCREV = "ebfc71d70b39dc5a88b91aa72df669fc67f838cb"

COMPATIBLE_MACHINE = "(usom02)"

include linux.inc

PR = "r2"

KERNEL_DEVICETREE = "socfpga_cyclone5.dtb"

KERNEL_VERSION = "3.10"
