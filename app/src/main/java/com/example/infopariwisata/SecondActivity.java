package com.example.infopariwisata;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private List<InfoPariwisata> wisataList = new ArrayList<>();
    private List<InfoPariwisata> filteredList = new ArrayList<>();
    private SearchView searchView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        loadData();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        filteredList.addAll(wisataList);
        adapter = new Adapter(filteredList, this);
        recyclerView.setAdapter(adapter);

        searchView = findViewById(R.id.searchView);
        searchView.setQueryHint("Cari destinasi wisata");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });
    }

    private void loadData() {
        wisataList.add(new InfoPariwisata("Gunung Bromo", "Malang, Jawa Timur", R.drawable.bromo,
                "Gunung Bromo adalah gunung berapi aktif yang terkenal dengan keindahan alamnya. Terletak di Taman Nasional Bromo Tengger Semeru, tempat ini menawarkan pemandangan matahari terbit yang spektakuler dan lautan pasir yang luas. Para wisatawan dapat menikmati perjalanan dengan jeep untuk menyaksikan fenomena alam yang menakjubkan. Bromo juga merupakan destinasi populer bagi para fotografer untuk menangkap momen indah saat matahari terbit. Suasana sekitar yang sunyi dan udara sejuk menambah daya tarik tempat ini.", 4.5));
        wisataList.add(new InfoPariwisata("Candi Borobudur", "Magelang, Jawa Tengah", R.drawable.borobudur,
                "Candi Borobudur adalah candi Buddha terbesar di dunia dan merupakan salah satu Warisan Dunia UNESCO. Dibangun pada abad ke-8, candi ini memiliki arsitektur yang megah dan dihiasi dengan ribuan relief yang menggambarkan ajaran Buddha. Candi ini terdiri dari sembilan tingkat dan dikelilingi oleh pemandangan alam yang menakjubkan, termasuk pegunungan yang hijau. Pengunjung dapat menikmati pemandangan matahari terbit yang luar biasa dari puncak candi. Borobudur juga menjadi tujuan spiritual bagi banyak peziarah dari seluruh dunia.", 4.7));
        wisataList.add(new InfoPariwisata("Danau Toba", "Samosir, Sumatera Utara", R.drawable.danautoba,
                "Danau Toba adalah danau vulkanik terbesar di dunia dan merupakan salah satu destinasi wisata paling populer di Indonesia. Dikelilingi oleh pegunungan yang indah, danau ini juga memiliki pulau Samosir di tengahnya, yang kaya akan budaya Batak. Keindahan alam yang luar biasa danau ini menjadikannya tempat yang ideal untuk berlibur dan bersantai. Di sekitar danau, terdapat banyak desa yang menawarkan pengalaman budaya yang autentik. Pengunjung dapat menikmati berbagai aktivitas air, seperti berperahu, serta mencicipi kuliner khas Batak.", 4.3));
        wisataList.add(new InfoPariwisata("Gili Trawangan", "Lombok, Nusa Tenggara Barat", R.drawable.gilitrawangan,
                "Gili Trawangan adalah pulau kecil yang terkenal dengan pantainya yang indah dan suasana santai. Dengan air laut yang jernih dan terumbu karang yang menakjubkan, pulau ini adalah surga bagi para penyelam dan pencinta pantai. Tidak ada kendaraan bermotor di pulau ini, yang membuat suasana lebih tenang dan damai. Pengunjung dapat menikmati berbagai aktivitas seperti snorkeling, diving, atau bersepeda mengelilingi pulau. Gili Trawangan juga terkenal dengan kehidupan malam yang meriah, menawarkan bar dan restoran yang unik.", 4.6));
        wisataList.add(new InfoPariwisata("Raja Ampat", "Raja Ampat, Papua Barat", R.drawable.rajaampat,
                "Raja Ampat adalah kepulauan yang terkenal dengan keanekaragaman hayati lautnya yang luar biasa. Dengan lebih dari 1.500 spesies ikan dan 600 spesies karang, tempat ini adalah surga bagi penyelam dan pecinta alam. Raja Ampat juga dikenal dengan keindahan pemandangan alamnya yang sangat menakjubkan, termasuk pulau-pulau karst yang menjulang tinggi. Area ini memiliki banyak tempat yang belum terjamah dan menawarkan pengalaman berlibur yang sangat eksklusif. Di sini, wisatawan dapat menikmati aktivitas laut seperti snorkeling dan diving, atau sekadar berkeliling pulau dengan perahu.", 4.8));
        wisataList.add(new InfoPariwisata("Pantai Kuta", "Badung, Bali", R.drawable.pantaikuta,
                "Pantai Kuta adalah salah satu pantai paling terkenal di Bali, dikenal dengan ombaknya yang cocok untuk berselancar dan pemandangan matahari terbenam yang menakjubkan. Pantai ini juga dikelilingi oleh berbagai restoran, bar, dan toko-toko. Dengan pasir putih yang luas, tempat ini menjadi destinasi utama bagi para pelancong yang mencari relaksasi atau aktivitas air. Kuta juga dikenal dengan kehidupan malam yang meriah, dengan banyak tempat hiburan yang dapat dinikmati. Pantai Kuta juga menjadi tempat favorit bagi mereka yang ingin mencoba berbagai olahraga air, termasuk surfing.", 4.3));
        wisataList.add(new InfoPariwisata("Kawah Ijen", "Banyuwangi, Jawa Timur", R.drawable.kawahijen,
                "Kawah Ijen adalah kawah vulkanik yang terkenal dengan api biru dan danau belerangnya yang berwarna hijau toska. Tempat ini menawarkan pengalaman hiking yang menantang dan pemandangan yang luar biasa, terutama saat matahari terbit. Para wisatawan dapat menyaksikan fenomena api biru yang hanya ada di beberapa tempat di dunia. Kawah Ijen juga menjadi tempat para penambang belerang yang bekerja keras di area berbahaya ini. Pengunjung yang datang ke Kawah Ijen akan disuguhkan pemandangan yang unik dan menantang di setiap langkahnya.", 4.4));
        wisataList.add(new InfoPariwisata("Pulau Komodo", "Manggarai Barat, Nusa Tenggara Timur", R.drawable.pulaukomodo,
                "Pulau Komodo adalah rumah bagi komodo, kadal terbesar di dunia. Sebagai bagian dari Taman Nasional Komodo, pulau ini menawarkan keindahan alam yang menakjubkan serta kesempatan untuk melihat satwa liar yang unik. Di sini, pengunjung dapat melakukan trekking untuk melihat komodo di habitat aslinya. Pulau ini juga dikenal dengan pantai-pantai indahnya dan perairan yang kaya akan kehidupan laut. Komodo menjadi salah satu destinasi utama untuk ekowisata di Indonesia dan sering menjadi tujuan bagi para penggemar petualangan dan pecinta alam.", 4.6));
        wisataList.add(new InfoPariwisata("Tana Toraja", "Toraja, Sulawesi Selatan", R.drawable.tanatoraja,
                "Tana Toraja dikenal dengan budaya dan tradisi uniknya, termasuk upacara pemakaman yang megah. Dikelilingi oleh pegunungan yang indah, daerah ini juga terkenal dengan rumah adat yang khas dan sawah terasering yang menawan. Tradisi dan kehidupan masyarakat Toraja yang masih terjaga dengan baik membuat daerah ini menjadi daya tarik wisata yang sangat menarik. Tana Toraja juga dikenal dengan tempat pemakaman yang sangat unik, seperti kuburan yang terletak di tebing-tebing tinggi. Pemandangan alam yang menakjubkan dan tradisi yang kental membuat Toraja sangat berbeda dari tempat wisata lainnya.", 4.5));
        wisataList.add(new InfoPariwisata("Candi Prambanan", "Sleman, Yogyakarta", R.drawable.candiprambanan,
                "Candi Prambanan adalah kompleks candi Hindu terbesar di Indonesia, yang dibangun pada abad ke-9. Candi ini terdiri dari lebih dari 240 candi kecil dan merupakan Warisan Dunia UNESCO. Prambanan terkenal dengan arsitektur candi yang megah dan relief-relief yang menggambarkan kisah Ramayana. Pengunjung dapat menyaksikan kemegahan candi yang dikelilingi oleh taman yang indah. Candi ini juga menjadi tempat pertunjukan seni budaya, seperti tari Ramayana, yang memperkaya pengalaman berwisata.", 4.7));
        wisataList.add(new InfoPariwisata("Malioboro", "Yogyakarta", R.drawable.malioboro,
                "Malioboro adalah salah satu jalan terkenal di Yogyakarta yang menjadi pusat perbelanjaan dan budaya. Dikenal dengan berbagai toko yang menjual kerajinan tangan, batik, dan oleh-oleh khas, Malioboro adalah tempat yang wajib dikunjungi bagi wisatawan. Jalan ini juga dikelilingi oleh berbagai restoran dan kafe yang menawarkan masakan khas Yogyakarta. Pengunjung dapat menikmati suasana jalanan yang ramai dengan kendaraan tradisional seperti andong. Malioboro adalah simbol kehidupan kota Yogyakarta yang tidak pernah sepi.", 4.5));
        wisataList.add(new InfoPariwisata("Nusa Penida", "Bali", R.drawable.nusapenida,
                "Nusa Penida adalah pulau yang terletak di sebelah tenggara Bali dan terkenal dengan pemandangan alam yang luar biasa. Pulau ini memiliki tebing-tebing curam, pantai berpasir putih, dan air laut yang sangat jernih. Nusa Penida juga menjadi tempat favorit bagi para penyelam untuk melihat kehidupan laut yang kaya. Salah satu daya tarik utamanya adalah Pantai Keling-Keling, yang terkenal dengan formasi batu karangnya yang unik. Selain itu, pengunjung juga bisa menjelajahi beberapa tempat wisata alam yang eksotis seperti Angel's Billabong dan Broken Beach.", 4.7));
        wisataList.add(new InfoPariwisata("Panglipuran", "Bali", R.drawable.panglipuran,
                "Panglipuran adalah desa adat yang terletak di Bangli, Bali, yang terkenal dengan kebudayaan dan tradisi Bali yang masih sangat terjaga. Desa ini memiliki arsitektur yang unik dan lingkungan yang asri, dengan jalan-jalan yang bersih dan tertata rapi. Panglipuran juga dikenal dengan suasana yang tenang, jauh dari keramaian wisatawan, sehingga menjadi tempat yang ideal untuk berlibur dan menikmati budaya Bali. Pengunjung dapat melihat kehidupan sehari-hari masyarakat Bali dan belajar tentang tradisi serta upacara adat yang mereka jalani.", 4.6));

        filteredList.addAll(wisataList);

    }

        private void filterList(String query) {
            filteredList.clear();
            for (InfoPariwisata item : wisataList) {
                if (item.getName().toLowerCase().contains(query.toLowerCase()) ||
                        item.getLocation().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(item);
                }
            }
            adapter.notifyDataSetChanged();
        }
    }
