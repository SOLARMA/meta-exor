FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append() {
    rm ${D}${sysconfdir}/xdg/autostart/xinput_calibrator.desktop
}
