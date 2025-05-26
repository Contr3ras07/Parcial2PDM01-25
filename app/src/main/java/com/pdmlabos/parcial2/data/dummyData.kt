package com.pdmlabos.parcial2.data

import com.pdmlabos.parcial2.model.Product

object ProductRepository {
    val productList = listOf(
        Product(1, "Mouse", "Periféricos", 115.99, "Mouse inalámbrico con sensor óptico de 24,000 DPI, RGB personalizable, ideal para gaming competitivo.", "https://www.diez.hn/binrepository/1200x675/0c0/0d0/none/3014757/HKIB/razer_5907644_20231030182024.jpg"),
        Product(2, "Teclado", "Periféricos", 115.00, "Teclado mecánico con switches ópticos, retroiluminación RGB, reposamuñecas magnético, y carcasa de aluminio.", "https://i.blogs.es/3128d3/comprar-teclado-razer-huntsman-v3-pro-al-mejor-precio-amazon/650_1200.jpg"),
        Product(3, "Monitor", "Monitores", 299.99, "Monitor gamer de 24 pulgadas, resolución QHD, tasa de refresco de 240Hz y tecnología AMD FreeSync Premium.", "https://www.acerstore.cl/cdn/shop/files/1_XZ342CU.png?v=1742563697"),
        Product(4, "Laptop", "Computadoras", 999.99, "Laptop gamer con pantalla de 16 pulgadas, GPU NVIDIA RTX 5070, procesador Intel Ultra9 y 32GB RAM DDR5.", "https://cnnespanol.cnn.com/wp-content/uploads/2021/11/laptop-gamer-amd.png"),
        Product(5, "Airpods Pro", "Audio", 85.50, "Audífonos inalámbricos con cancelación activa de ruido, batería de 40h y micrófono integrado con claridad HD.", "https://think-ecuador.com/wp-content/uploads/2024/02/0160300827.jpeg"),
        Product(6, "Webcam", "Periféricos", 69.99, "Cámara web 1080p Full HD, lente gran angular, ideal para videollamadas, streaming y clases virtuales.", "https://phantom-marca.unidadeditorial.es/b715c92f01887b6b308ab922c6a19e1b/resize/828/f/jpg/assets/multimedia/imagenes/2024/06/25/17193379786027.jpg"),
        Product(7, "Silla Gamer", "Muebles", 179.00, "Silla ergonómica estilo racing con cojín lumbar, soporte cervical y reclinación de 180° para largas sesiones.", "https://assets2.razerzone.com/images/pnx.assets/7f39feb6aff2401707b491d36cd1cd39/razer-iskur.jpg"),
        Product(8, "Disco SSD", "Almacenamiento", 149.99, "SSD NVMe Gen4 de 2TB con velocidades de lectura de hasta 7000MB/s, ideal para cargas ultra rápidas.", "https://www.steren.com.sv/media/catalog/product/cache/0236bbabe616ddcff749ccbc14f38bf2/image/208199c79/disco-duro-interno-de-estado-solido-ssd-240-gb-2-5-sata-ii-ii.jpg"),
        Product(9, "IPad", "Electrónica", 299.00, "Tablet de 11 pulgadas, pantalla AMOLED, 6GB de RAM, 128GB almacenamiento, ideal para multimedia y estudio.", "https://istore.gt/wp-content/uploads/2022/03/EC00130-1.jpg"),
        Product(10, "Router Wi-Fi 6", "Redes", 120.00, "Router con tecnología Wi-Fi 6, velocidades hasta 5400Mbps, 4 antenas externas y administración por app.", "https://m.media-amazon.com/images/I/71HzNl--8qL._AC_UF894,1000_QL80_.jpg")
    )
}
