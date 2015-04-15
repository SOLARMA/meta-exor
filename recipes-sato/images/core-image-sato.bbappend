IMAGE_FEATURES_remove = "ssh-server-dropbear"
IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_INSTALL += "gdbserver openvpn openssh-sftp-server"

# Uncomment to install Qt library on the board
#IMAGE_INSTALL += "packagegroup-core-qt-demoapps packagegroup-qt-toolchain-target"

# Uncomment to include chromium web browser on the board
#CORE_IMAGE_EXTRA_INSTALL += "chromium"

