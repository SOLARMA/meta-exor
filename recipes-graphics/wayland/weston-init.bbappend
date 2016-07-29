FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/${MACHINE}:${THISDIR}/${PN}:"

SRC_URI += "file://weston.ini"

do_install_append () {
	install -d ${D}/${sysconfdir}/xdg/weston
	install -m 755 ${S}/weston.ini ${D}/${sysconfdir}/xdg/weston
}
