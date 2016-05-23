LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=6;md5=157ab8408beab40cd8ce1dc69f702a6c"
LIC_FILES_CHKSUM_usom02 = "file://README;beginline=1;endline=6;md5=05908ffcfd3d7d846e5c7eafa9ab62de"

SRC_URI = "git://github.com/ExorEmbedded/uboot-us01.git;protocol=git;branch=uboot2014.04_uS01"
SRCREV = "df5ee4af9551111dc552b98f20e1fed8380c0be5"

SRC_URI_usom02 = "git://github.com/ExorEmbedded/uboot-us02.git;protocol=git;branch=master"
SRCREV_usom02 = "cab40e340784b1dbf7c5a0f72697f0c1ae066d42"

require ../u-boot.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

UBOOT_ONLY = "1"
