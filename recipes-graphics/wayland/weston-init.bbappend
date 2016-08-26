FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/${MACHINE}:${THISDIR}/${PN}:"

SRC_URI += "file://weston.ini"

do_install_append () {
	install -d ${D}/${sysconfdir}/xdg/weston
	install -d ${D}/${sysconfdir}/profile.d
	install -m 755 ${S}/weston.ini ${D}/${sysconfdir}/xdg/weston
	echo "export XDG_RUNTIME_DIR=/run/user/root" > ${D}/${sysconfdir}/profile.d/xdg
	chmod 755 ${D}/${sysconfdir}/profile.d/xdg
}
