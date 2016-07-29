SUMMARY = "Ultra-simple screen capture utility, aimed at handheld devices"
HOMEPAGE = "http://www.o-hand.com"
BUGTRACKER = "http://bugzilla.yoctoproject.org/"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b9ed56aa8997241d26cf7e4ff11745c9"

DEPENDS = "gnome-desktop3 gnome-menus3 weston"
SRCREV = "a191e5c0b9593dfa203cbe83d43ac2699e51be6c"
PV = "0.1+git${SRCPV}"
PR = "r1"

SRC_URI = "git://github.com/raspberrypi/maynard"

S = "${WORKDIR}/git"
B = "${S}"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/glib-2.0/schemas/* \
	${libdir}/weston/*"

do_configure () {
	${S}/autogen.sh ${CONFIGUREOPTS}
}
