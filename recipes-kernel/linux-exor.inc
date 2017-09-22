# Use in-tree defconfig
KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} O=${B} ${KERNEL_MACHINE}_defconfig"
