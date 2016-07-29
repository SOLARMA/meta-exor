FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://xinput_calibrator.desktop"

do_install_append() {
    rm ${D}${sysconfdir}/xdg/autostart/xinput_calibrator.desktop

    # Replace /usr/share/applications/xinput_calibrator.desktop
    install -m 755 ${WORKDIR}/xinput_calibrator.desktop ${D}/${datadir}/applications/
}
