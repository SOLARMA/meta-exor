QT5 = "qtbase \
	qtwebengine \
	qtwebengine-examples \
"

IMAGE_INSTALL += "jmobile-portable \
                openvpn \
                openssh-sftp-server \
                gst-meta-base \
		packagegroup-cli-tools \
		packagegroup-cli-tools-debug \
		gdbserver \
		${QT5} \
"

# Uncomment to include chromium web browser on the board. The build
# requires at least 8GB of free RAM memory otherwise the linking phase may fail
#CORE_IMAGE_EXTRA_INSTALL += "chromium"

ROOTFS_POSTPROCESS_COMMAND += "jmInstall;"

jmInstall() {
   JMobilePkg="${IMAGE_ROOTFS}/home/root/jmobile_portable.tar.gz"
   [ -f ${JMobilePkg} ] && tar xzf ${JMobilePkg} -C ${IMAGE_ROOTFS}/home/root; rm ${JMobilePkg}
}

inherit populate_sdk_qt5

TOOLCHAIN_OUTPUTNAME = "exor-evm-qt5-sdk"
