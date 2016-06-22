DESCRIPTION = "JMobile Portable"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ce29dbb849109f28c0a0358e8fedbc64"

PR = "1"
PV = "233"

SRC_URI = "file://jmobile.desktop"

JM_URI_usom01 = "http://download.exorembedded.net:8080/Public/${MACHINE}/JMobile/jmobile2.01-${PV}-${PR}_portable_us01kit_cds3.tar.gz"
JM_URI_usom02 = "http://download.exorembedded.net:8080/Public/${MACHINE}/JMobile/jmobile2.01-${PV}-${PR}_portable_alterakit_cds3.tar.gz"

do_fetch() {
	wget ${JM_URI} -O ${WORKDIR}/jmobile_portable.tar.gz
}

do_configure() {
	tar xzf ${WORKDIR}/jmobile_portable.tar.gz portable/LICENSE.txt --strip 1 -C ${S}
}

do_install() {
	install -d ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/jmobile.desktop ${D}${datadir}/applications/
	install -d ${D}/home/root
	install -m 0644 ${WORKDIR}/jmobile_portable.tar.gz ${D}/home/root 
}

FILES_${PN} = "${datadir}/applications/ /home/root/jmobile_portable.tar.gz"
