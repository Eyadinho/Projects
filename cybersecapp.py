import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QVBoxLayout, QWidget, QListWidget, QLabel, QTextEdit, QPushButton
from PyQt5.QtCore import Qt, QTimer
from PyQt5.QtGui import QIcon, QPixmap

class CyberSecurityApp(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Cyber Security Threats and Networking Terms")
        self.setGeometry(100, 100, 800, 600)

        central_widget = QWidget(self)
        self.setCentralWidget(central_widget)

        layout = QVBoxLayout(central_widget)

        # Robot label for animation
        self.robot_label = QLabel(self)
        self.robot_label.setAlignment(Qt.AlignCenter)
        layout.addWidget(self.robot_label)

        # Start animation timer
        self.animation_timer = QTimer(self)
        self.animation_timer.timeout.connect(self.animate_robot)
        self.animation_timer.start(100)

        # Title label
        title_label = QLabel("Common Cyber Security Threats and Networking Terms", self)
        title_label.setStyleSheet("font-size: 24px; font-weight: bold; margin-bottom: 20px; color: #333;")
        layout.addWidget(title_label, alignment=Qt.AlignCenter)

        # List widget to select threat or networking term
        self.list_widget = QListWidget(self)
        self.list_widget.addItems([
            "ARP (Address Resolution Protocol)", "Backdoor", "Brute Force Attack", "DHCP (Dynamic Host Configuration Protocol)",
            "DNS (Domain Name System)", "DoS (Denial of Service) Attack", "Firewall", "FTP (File Transfer Protocol)",
            "ICMP (Internet Control Message Protocol)", "IP (Internet Protocol) Address", "MAC (Media Access Control) Address",
            "Man-in-the-Middle (MitM) Attack", "Malware", "Packet Sniffing", "Phishing", "Port Scanning",
            "Ransomware", "Rootkit", "SMTP (Simple Mail Transfer Protocol)", "Social Engineering",
            "Spoofing", "SSL (Secure Sockets Layer)", "Subnet Mask", "TCP (Transmission Control Protocol)",
            "Trojan Horse", "UDP (User Datagram Protocol)", "VPN (Virtual Private Network)", "Zero-Day Exploit",
            "Two-Factor Authentication (2FA)"
        ])
        self.list_widget.setStyleSheet("font-size: 18px; margin-bottom: 20px; background-color: #f0f0f0; border: 2px solid #ccc; border-radius: 10px;")
        layout.addWidget(self.list_widget)

        # Text edit widget to display threat or networking term information
        self.info_text = QTextEdit(self)
        self.info_text.setReadOnly(True)
        self.info_text.setStyleSheet("font-size: 16px; background-color: #f0f0f0; border: 2px solid #ccc; border-radius: 10px;")
        layout.addWidget(self.info_text)

        # Button to show more details
        self.details_button = QPushButton("Show Details", self)
        self.details_button.setStyleSheet("font-size: 18px; padding: 10px 20px; margin-top: 20px; background-color: #007bff; color: white; border: none; border-radius: 10px;")
        layout.addWidget(self.details_button, alignment=Qt.AlignCenter)

        # Connect signals
        self.list_widget.itemClicked.connect(self.show_info)
        self.details_button.clicked.connect(self.show_details_info)

        # Set window icon
        self.setWindowIcon(QIcon('icon.png'))

        # Preload all info texts
        self.info_texts = {
            "ARP (Address Resolution Protocol)": "ARP (Address Resolution Protocol) is a protocol used for mapping an IP address to a MAC address on a local network.",
            "Backdoor": "A Backdoor is a hidden entry point into a system or software that bypasses normal authentication mechanisms, allowing unauthorized access to the system.",
            "Brute Force Attack": "A Brute Force Attack is a trial-and-error method used by cybercriminals to crack passwords or encryption by systematically trying all possible combinations of characters.",
            "DHCP (Dynamic Host Configuration Protocol)": "DHCP (Dynamic Host Configuration Protocol) is a network management protocol used to automatically assign IP addresses and other network configuration parameters to devices on a network.",
            "DNS (Domain Name System)": "DNS (Domain Name System) is a hierarchical decentralized naming system for computers, services, or other resources connected to the Internet or a private network.",
            "DoS (Denial of Service) Attack": "A Denial of Service (DoS) attack is a cyber attack in which the perpetrator seeks to make a machine or network resource unavailable to its intended users by temporarily or indefinitely disrupting services of a host connected to the Internet.",
            "Firewall": "A firewall is a network security system that monitors and controls incoming and outgoing network traffic based on predetermined security rules.",
            "FTP (File Transfer Protocol)": "FTP (File Transfer Protocol) is a standard network protocol used to transfer files from one host to another over a TCP-based network, such as the Internet.",
            "ICMP (Internet Control Message Protocol)": "ICMP (Internet Control Message Protocol) is a protocol used to send error messages and operational information indicating, for example, that a requested service is not available or that a host or router could not be reached.",
            "IP (Internet Protocol) Address": "An IP (Internet Protocol) address is a unique numerical label assigned to each device connected to a computer network that uses the Internet Protocol for communication.",
            "MAC (Media Access Control) Address": "A MAC (Media Access Control) address, also known as a hardware address or physical address, is a unique identifier assigned to network interfaces for communications on the physical network segment.",
                        "Man-in-the-Middle (MitM) Attack": "A Man-in-the-Middle (MitM) attack is a cyber attack where the attacker secretly intercepts and relays messages between two parties who believe they are communicating directly with each other.",
            "Malware": "Malware is malicious software designed to damage or gain unauthorized access to a computer system.",
            "Packet Sniffing": "Packet Sniffing is the process of intercepting and logging network traffic passing through a network interface in real-time.",
            "Phishing": "Phishing is a cyber attack method that involves sending fraudulent emails or messages to trick individuals into revealing sensitive information.",
            "Port Scanning": "Port Scanning is the process of systematically scanning a computer or network to find open ports, which may indicate vulnerabilities or services running on the system.",
            "Ransomware": "Ransomware is a type of malware that encrypts files on a victim's computer and demands payment for their release.",
            "Rootkit": "A Rootkit is a type of malicious software that enables unauthorized access to a computer or network while hiding its presence from users and security programs.",
            "SMTP (Simple Mail Transfer Protocol)": "SMTP (Simple Mail Transfer Protocol) is a protocol used for sending email messages between servers.",
            "Social Engineering": "Social engineering is a manipulation technique used by cybercriminals to deceive individuals into divulging confidential information or performing actions that may compromise their security.",
            "Spoofing": "Spoofing is a cyber attack in which an attacker masquerades as a trusted entity or source to deceive victims, manipulate their actions, or gain unauthorized access to systems.",
            "SSL (Secure Sockets Layer)": "SSL (Secure Sockets Layer) is a protocol for securing and encrypting data transmitted over the Internet.",
            "Subnet Mask": "A Subnet Mask is a 32-bit number that masks an IP address, and divides the IP address into network address and host address.",
            "TCP (Transmission Control Protocol)": "TCP (Transmission Control Protocol) is a connection-oriented protocol that provides reliable and ordered delivery of data between devices.",
            "Trojan Horse": "A Trojan Horse is a type of malware that appears to perform a desirable function for the user prior to run or install but instead facilitates unauthorized access to the user's computer system.",
            "UDP (User Datagram Protocol)": "UDP (User Datagram Protocol) is a connectionless protocol that allows for the transmission of data packets between devices on a network.",
            "VPN (Virtual Private Network)": "A Virtual Private Network (VPN) extends a private network across a public network, and enables users to send and receive data across shared or public networks as if their computing devices were directly connected to the private network.",
            "Zero-Day Exploit": "A Zero-Day Exploit is a cyber attack that occurs on the same day a weakness is discovered in software. Attackers target the vulnerability before it has been patched or mitigated by the software developer.",
            "Two-Factor Authentication (2FA)": "Two-Factor Authentication (2FA) is a security process in which users provide two different authentication factors to verify themselves, typically a combination of something they know (e.g., a password) and something they have (e.g., a smartphone)."
        }

        # Set window icon
        self.setWindowIcon(QIcon('icon.png'))

    def show_info(self, item):
        threat = item.text()
        info = self.info_texts.get(threat, "")
        self.info_text.setText(info)

    def show_details_info(self):
        selected_threat = self.list_widget.currentItem().text()
        info = self.info_texts.get(selected_threat, "")
        self.info_text.setText(info)

    def animate_robot(self):
        # Replace the path below with the path to your robot image
        pixmap = QPixmap('robot.gif')
        self.robot_label.setPixmap(pixmap)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = CyberSecurityApp()
    window.show()
    sys.exit(app.exec_())

