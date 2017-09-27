# Use in-tree defconfig
do_preconfigure[noexec] = "1"
KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} O=${B} ${KERNEL_MACHINE}_defconfig"
