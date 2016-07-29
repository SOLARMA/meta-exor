
do_compile_append () {
    cd ${S}/examples
    oe_runmake
}

do_install_append() {
    cd ${S}/examples
    oe_runmake install INSTALL_ROOT=${D}
}

