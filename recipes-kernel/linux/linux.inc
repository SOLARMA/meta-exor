inherit kernel
require recipes-kernel/linux/linux-yocto.inc

PV = "${KERNEL_VERSION}+git${SRCPV}"

SRC_URI += "file://defconfig"

COMPATIBLE_MACHINE = "(usom02)"

KERNEL_IMAGETYPE = "zImage"
KERNEL_EXTRA_ARGS = "dtbs"

DTB_OUTPUT = "arch/arm/boot/dts"

do_deploy_append() {
   install -d "${DEPLOYDIR}"
   install -m 0644 "${B}/${KERNEL_OUTPUT}" "${DEPLOYDIR}"
   for DTB in ${KERNEL_DEVICETREE}; do
      install -m 0644 "${B}/${DTB_OUTPUT}/${DTB}" "${DEPLOYDIR}"
   done

   cd "${DEPLOYDIR}"
   mv ${KERNEL_DEVICETREE} socfpga.dtb
   tar czvf "us02-kernel-${KERNEL_VERSION}-${DATETIME}.tar.gz" "${KERNEL_IMAGETYPE}" socfpga.dtb
   ln -sf "us02-kernel-${KERNEL_VERSION}-${DATETIME}.tar.gz" us02-kernel.tar.gz

   rm -rf  ${KERNEL_IMAGETYPE}*
   rm -rf *.dtb
}

RDEPENDS_kernel-base = ""
