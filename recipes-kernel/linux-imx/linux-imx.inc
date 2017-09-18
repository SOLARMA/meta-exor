# Copyright (C) 2012, 2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel fsl-kernel-localversion

FILESEXTRAPATH_prepend = "${THISDIR}/files:"

# Put a local version until we have a true SRCREV to point to
LOCALVERSION = "-1.0.0_ga"
SCMVERSION = "y"
SRCBRANCH = "master"
SRCREV = "e9cfc3a6fb75e8e78d46481028691504167917fe"

SRC_URI = "git://github.com/ExorEmbedded/linux-us03.git;branch=${SRCBRANCH} \
           file://defconfig \
           file://0001-Added-compiler-gcc6.h.patch \
           file://0002-use-static-inline-in-ARM-ftrace.patch \
           file://0003-change-extern-inline-to-static-inline-in-glue-cache.patch \
"

S = "${WORKDIR}/git"

# We need to pass it as param since kernel might support more then one
# machine, with different entry points
#KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
