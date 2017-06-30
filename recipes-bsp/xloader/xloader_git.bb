LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=6;md5=157ab8408beab40cd8ce1dc69f702a6c"

SRC_URI = "git://github.com/ExorEmbedded/uboot-us01.git;protocol=git;branch=uboot2014.04_uS01"
SRCREV = "e7340191ba8c56f8c8733cc217cacc86030ac81a"

COMPATIBLE_MACHINE = "usom01"

require ../u-boot.inc

SPL_ONLY = "1"
SPL_BINARY = "MLO"
