
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "${@oe.utils.conditional('CHROMIUM_ENABLE_WAYLAND', '1', 'file://001-bypass-mesa-version-check.patch', '', d)}"

SRC_URI_append_usom01 += " file://libva-use-intree-headers.patch"

RDEPENDS_${PN} += "libexif"
