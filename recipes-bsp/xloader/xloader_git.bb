LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=6;md5=157ab8408beab40cd8ce1dc69f702a6c"

SRC_URI = "git://github.com/ExorEmbedded/uboot-us01.git;protocol=git;branch=uboot2014.04_uS01"
SRCREV = "df5ee4af9551111dc552b98f20e1fed8380c0be5"

COMPATIBLE_MACHINE = "usom01"

require ../u-boot.inc

SPL_ONLY = "1"
SPL_BINARY = "MLO"
