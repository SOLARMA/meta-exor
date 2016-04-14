LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=e4d887fab6c87d6b06f03959cac48138"

VERSION = "US02HSXXB00000000"
SRCNAME = "uboot"
SRC_URI = "git://github.com/ExorEmbedded/uboot-us02.git;protocol=git"
SRC_URI[md5sum] = "7094df7dedb134fa41ee6679a34de190"
SRBCRANCH = "master"
SRCREV = "cab40e340784b1dbf7c5a0f72697f0c1ae066d42"
PR = "r3"

S = "${WORKDIR}/git"

require ../u-boot.inc
