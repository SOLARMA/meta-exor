DESCRIPTION = "JMobile Portable"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ce29dbb849109f28c0a0358e8fedbc64"

PR = "2"
PV = "233"

JM_URI = "http://download.exorembedded.net:8080/Public/usom01/JMobile/jmobile2.01-${PV}-${PR}_portable_us01kit_cds3.tar.gz"
JM_URI_us02-kit = "http://download.exorembedded.net:8080/Public/usom02/JMobile/jmobile2.01-${PV}-${PR}_portable_alterakit_cds3.tar.gz"
JM_URI_us03-kit = "http://download.exorembedded.net:8080/Public/usom03/JMobile/jmobile2.01-${PV}-${PR}_portable_us03kit_cds3.tar.gz"
JM_URI_ns01-kit = "http://download.exorembedded.net:8080/Public/usom03/JMobile/jmobile2.01-${PV}-${PR}_portable_us03kit_cds3.tar.gz"

SRC_URI = "file://jmobile.desktop ${JM_URI}"

S = "${WORKDIR}/portable"

do_install() {
	install -d ${D}${datadir}/applications
	install -d ${D}/home/root

	install -m 0644 ${WORKDIR}/jmobile.desktop ${D}${datadir}/applications/
	cp -a ${S} ${D}/home/root
}

BB_STRICT_CHECKSUM = "0"
INSANE_SKIP_${PN} += "installed-vs-shipped already-stripped"
