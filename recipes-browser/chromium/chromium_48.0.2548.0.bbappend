
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_usom01 += "file://001-bypass-mesa-version-check.patch \
	file://libva-use-intree-headers.patch"

RDEPENDS_${PN} += "libexif"
