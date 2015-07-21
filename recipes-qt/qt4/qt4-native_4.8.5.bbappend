do_compile() {
        cd ${S} && oe_runmake CC="${CC}" CXX="${CXX}"
}

#do_populate_sysroot[postfuncs] = ""

do_install() {
        install -d ${D}${bindir}/
        install -m 0755 bin/qmake ${D}${bindir}/qmake2
        for i in moc uic uic3 rcc lconvert lrelease lupdate qdbuscpp2xml qdbusxml2cpp xmlpatterns; do
		[ -e "bin/${i}" ] && install -m 0755 bin/${i} ${D}${bindir}/${i}4
        done

        install -d ${D}${datadir}/qt4/
        cp -PfR mkspecs ${D}${datadir}/qt4/
        ln -sf linux-g++ ${D}${datadir}/qt4/mkspecs/${BUILD_OS}-oe-g++
        if [ -f ${D}${datadir}/qt4/mkspecs/common/g++-unix.conf ] ; then
                # mkspecs were refactored for 4.8.0
                cp -f ${WORKDIR}/g++.conf ${D}${datadir}/qt4/mkspecs/common/g++-unix.conf
        else
                cp -f ${WORKDIR}/g++.conf ${D}${datadir}/qt4/mkspecs/common/g++.conf
        fi
        cp -f ${WORKDIR}/linux.conf ${D}${datadir}/qt4/mkspecs/common/

        install -m 0644 tools/porting/src/q3porting.xml ${D}${datadir}/qt4/

        cd ${S} && oe_runmake install INSTALL_ROOT=${D}
}

