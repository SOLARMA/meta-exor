LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=e4d887fab6c87d6b06f03959cac48138"

VERSION = "US02HSXXB00000000"
SRCNAME = "uboot"
SRC_URI = "git://github.com/ExorEmbedded/uboot-us02.git;protocol=git"
SRC_URI[md5sum] = "7094df7dedb134fa41ee6679a34de190"
SRBCRANCH = "master"
SRCREV = "65a97b18f60551c7c45c9965c21fa59b66a1594f"
PR = "r2"

S = "${WORKDIR}/git"

require ../u-boot.inc

UBOOT_ONLY = "1"
UBOOT_SUFFIX = "img"
