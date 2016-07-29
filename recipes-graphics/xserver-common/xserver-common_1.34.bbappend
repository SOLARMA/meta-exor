FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " file://55xScreenSaver-nodpms"

do_install_append() {
	install -m 755 ${WORKDIR}/55xScreenSaver-nodpms ${D}${sysconfdir}/X11/Xinit.d/55xScreenSaver
}
