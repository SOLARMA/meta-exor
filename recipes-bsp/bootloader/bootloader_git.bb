LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=e4d887fab6c87d6b06f03959cac48138"

VERSION = "US02HSXXB00000000"
SRCNAME = "uboot"
SRC_URI = "git://github.com/ExorEmbedded/uboot-us02.git;protocol=git"
SRC_URI[md5sum] = "7094df7dedb134fa41ee6679a34de190"
SRBCRANCH = "master"
SRCREV = "01a2d95a6f6e2538f83ed206033486546125bf90"

S = "${WORKDIR}/git"

require ../u-boot.inc

UBOOT_ONLY = "1"
UBOOT_SUFFIX = "img"
