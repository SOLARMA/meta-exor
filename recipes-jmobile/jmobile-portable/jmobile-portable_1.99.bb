DESCRIPTION = "JMobile Portable"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ce29dbb849109f28c0a0358e8fedbc64"
SRC_URI = "\
	https://copy.com/JNh9V08fl4AH17h4/us02-public/jmobile_portable_alterakit_cds3.tar.gz?download=1;protocol=http \
        file://jmobile.desktop \
"
SRCREV = "r1"
BB_STRICT_CHECKSUM = ""

do_configure() {
	mv ${WORKDIR}/jmobile_portable_alterakit_cds3.tar.gz?download=1 ${WORKDIR}/jmobile_portable_alterakit_cds3.tar.gz
	tar xzf ${WORKDIR}/jmobile_portable_alterakit_cds3.tar.gz portable/LICENSE.txt --strip 1 -C ${S}
}

do_install() {
	install -d ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/jmobile.desktop ${D}${datadir}/applications/
	install -d ${D}/home/root
	install -m 0644 ${WORKDIR}/jmobile_portable_alterakit_cds3.tar.gz ${D}/home/root 
}

FILES_${PN} = "${datadir}/applications/ /home/root/jmobile_portable_alterakit_cds3.tar.gz"
