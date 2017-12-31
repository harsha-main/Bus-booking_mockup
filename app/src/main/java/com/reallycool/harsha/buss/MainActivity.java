package com.reallycool.harsha.buss;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {

    private static final String[] Cities = new String[] {
            "Adilabad","Agra","Ahmedabad","Ahmednagar","Aizawl","Ajitgarh (Mohali)","Ajmer","Akola","Alappuzha","Aligarh","Alirajpur","Allahabad","Almora","Alwar","Ambala","Ambedkar Nagar","Amravati","Amreli district","Amritsar","Anand","Anantapur","Anantnag","Angul","Anjaw","Anuppur","Araria","Ariyalur","Arwal","Ashok Nagar","Auraiya","Aurangabad","Aurangabad","Azamgarh","Badgam","Bagalkot","Bageshwar","Bagpat","Bahraich","Baksa","Balaghat","Balangir","Balasore","Ballia","Balrampur","Banaskantha","Banda","Bandipora","Bangalore Rural","Bangalore Urban","Banka","Bankura","Banswara","Barabanki","Baramulla","Baran","Bardhaman","Bareilly","Bargarh (Baragarh)","Barmer","Barnala","Barpeta","Barwani","Bastar","Basti","Bathinda","Beed","Begusarai","Belgaum","Bellary","Betul","Bhadrak","Bhagalpur","Bhandara","Bharatpur","Bharuch","Bhavnagar","Bhilwara","Bhind","Bhiwani","Bhojpur","Bhopal","Bidar","Bijapur","Bijapur","Bijnor","Bikaner","Bilaspur","Bilaspur","Birbhum","Bishnupur","Bokaro","Bongaigaon","Boudh (Bauda)","Budaun","Bulandshahr","Buldhana","Bundi","Burhanpur","Buxar","Cachar","Central Delhi","Chamarajnagar","Chamba","Chamoli","Champawat","Champhai","Chandauli","Chandel","Chandigarh","Chandrapur","Changlang","Chatra","Chennai","Chhatarpur","Chhatrapati Shahuji Maharaj Nagar","Chhindwara","Chikkaballapur","Chikkamagaluru","Chirang","Chitradurga","Chitrakoot","Chittoor","Chittorgarh","Churachandpur","Churu","Coimbatore","Cooch Behar","Cuddalore","Cuttack","Dadra and Nagar Haveli","Dahod","Dakshin Dinajpur","Dakshina Kannada","Daman","Damoh","Dantewada","Darbhanga","Darjeeling","Darrang","Datia","Dausa","Davanagere","Debagarh (Deogarh)","Dehradun","Deoghar","Deoria","Dewas","Dhalai","Dhamtari","Dhanbad","Dhar","Dharmapuri","Dharwad","Dhemaji","Dhenkanal","Dholpur","Dhubri","Dhule","Dibang Valley","Dibrugarh","Dima Hasao","Dimapur","Dindigul","Dindori","Diu","Doda","Dumka","Dungapur","Durg","East Champaran","East Delhi","East Garo Hills","East Khasi Hills","East Siang","East Sikkim","East Singhbhum","Eluru","Ernakulam","Erode","Etah","Etawah","Faizabad","Faridabad","Faridkot","Farrukhabad","Fatehabad","Fatehgarh Sahib","Fatehpur","Fazilka","Firozabad","Firozpur","Gadag","Gadchiroli","Gajapati","Ganderbal","Gandhinagar","Ganganagar","Ganjam","Garhwa","Gautam Buddh Nagar","Gaya","Ghaziabad","Ghazipur","Giridih","Goalpara","Godda","Golaghat","Gonda","Gondia","Gopalganj","Gorakhpur","Gulbarga","Gumla","Guna","Guntur","Gurdaspur","Gurgaon","Gwalior","Hailakandi","Hamirpur","Hamirpur","Hanumangarh","Harda","Hardoi","Haridwar","Hassan","Haveri district","Hazaribag","Hingoli","Hissar","Hooghly","Hoshangabad","Hoshiarpur","Howrah","Hyderabad","Hyderabad","Idukki","Imphal East","Imphal West","Indore","Jabalpur","Jagatsinghpur","Jaintia Hills","Jaipur","Jaisalmer","Jajpur","Jalandhar","Jalaun","Jalgaon","Jalna","Jalore","Jalpaiguri","Jammu","Jamnagar","Jamtara","Jamui","Janjgir-Champa","Jashpur","Jaunpur district","Jehanabad","Jhabua","Jhajjar","Jhalawar","Jhansi","Jharsuguda","Jhunjhunu","Jind","Jodhpur","Jorhat","Junagadh","Jyotiba Phule Nagar","Kabirdham (formerly Kawardha)","Kadapa","Kaimur","Kaithal","Kakinada","Kalahandi","Kamrup","Kamrup Metropolitan","Kanchipuram","Kandhamal","Kangra","Kanker","Kannauj","Kannur","Kanpur","Kanshi Ram Nagar","Kanyakumari","Kapurthala","Karaikal","Karauli","Karbi Anglong","Kargil","Karimganj","Karimnagar","Karnal","Karur","Kasaragod","Kathua","Katihar","Katni","Kaushambi","Kendrapara","Kendujhar (Keonjhar)","Khagaria","Khammam","Khandwa (East Nimar)","Khargone (West Nimar)","Kheda","Khordha","Khowai","Khunti","Kinnaur","Kishanganj","Kishtwar","Kodagu","Koderma","Kohima","Kokrajhar","Kolar","Kolasib","Kolhapur","Kolkata","Kollam","Koppal","Koraput","Korba","Koriya","Kota","Kottayam","Kozhikode","Krishna","Kulgam","Kullu","Kupwara","Kurnool","Kurukshetra","Kurung Kumey","Kushinagar","Kutch","Lahaul and Spiti","Lakhimpur","Lakhimpur Kheri","Lakhisarai","Lalitpur","Latehar","Latur","Lawngtlai","Leh","Lohardaga","Lohit","Lower Dibang Valley","Lower Subansiri","Lucknow","Ludhiana","Lunglei","Madhepura","Madhubani","Madurai","Mahamaya Nagar","Maharajganj","Mahasamund","Mahbubnagar","Mahe","Mahendragarh","Mahoba","Mainpuri","Malappuram","Maldah","Malkangiri","Mamit","Mandi","Mandla","Mandsaur","Mandya","Mansa","Marigaon","Mathura","Mau","Mayurbhanj","Medak","Meerut","Mehsana","Mewat","Mirzapur","Moga","Mokokchung","Mon","Moradabad","Morena","Mumbai City","Mumbai suburban","Munger","Murshidabad","Muzaffarnagar","Muzaffarpur","Mysore","Nabarangpur","Nadia","Nagaon","Nagapattinam","Nagaur","Nagpur","Nainital","Nalanda","Nalbari","Nalgonda","Namakkal","Nanded","Nandurbar","Narayanpur","Narmada","Narsinghpur","Nashik","Navsari","Nawada","Nawanshahr","Nayagarh","Neemuch","Nellore","New Delhi","Nilgiris","Nizamabad","North 24 Parganas","North Delhi","North East Delhi","North Goa","North Sikkim","North Tripura","North West Delhi","Nuapada","Ongole","Osmanabad","Pakur","Palakkad","Palamu","Pali","Palwal","Panchkula","Panchmahal","Panchsheel Nagar district (Hapur)","Panipat","Panna","Papum Pare","Parbhani","Paschim Medinipur","Patan","Pathanamthitta","Pathankot","Patiala","Patna","Pauri Garhwal","Perambalur","Phek","Pilibhit","Pithoragarh","Pondicherry","Poonch","Porbandar","Pratapgarh","Pratapgarh","Pudukkottai","Pulwama","Pune","Purba Medinipur","Puri","Purnia","Purulia","Raebareli","Raichur","Raigad","Raigarh","Raipur","Raisen","Rajauri","Rajgarh","Rajkot","Rajnandgaon","Rajsamand","Ramabai Nagar (Kanpur Dehat)","Ramanagara","Ramanathapuram","Ramban","Ramgarh","Rampur","Ranchi","Ratlam","Ratnagiri","Rayagada","Reasi","Rewa","Rewari","Ri Bhoi","Rohtak","Rohtas","Rudraprayag","Rupnagar","Sabarkantha","Sagar","Saharanpur","Saharsa","Sahibganj","Saiha","Salem","Samastipur","Samba","Sambalpur","Sangli","Sangrur","Sant Kabir Nagar","Sant Ravidas Nagar","Saran","Satara","Satna","Sawai Madhopur","Sehore","Senapati","Seoni","Seraikela Kharsawan","Serchhip","Shahdol","Shahjahanpur","Shajapur","Shamli","Sheikhpura","Sheohar","Sheopur","Shimla","Shimoga","Shivpuri","Shopian","Shravasti","Sibsagar","Siddharthnagar","Sidhi","Sikar","Simdega","Sindhudurg","Singrauli","Sirmaur","Sirohi","Sirsa","Sitamarhi","Sitapur","Sivaganga","Siwan","Solan","Solapur","Sonbhadra","Sonipat","Sonitpur","South 24 Parganas","South Delhi","South Garo Hills","South Goa","South Sikkim","South Tripura","South West Delhi","Sri Muktsar Sahib","Srikakulam","Srinagar","Subarnapur (Sonepur)","Sultanpur","Sundergarh","Supaul","Surat","Surendranagar","Surguja","Tamenglong","Tarn Taran","Tawang","Tehri Garhwal","Thane","Thanjavur","The Dangs","Theni","Thiruvananthapuram","Thoothukudi","Thoubal","Thrissur","Tikamgarh","Tinsukia","Tirap","Tiruchirappalli","Tirunelveli","Tirupur","Tiruvallur","Tiruvannamalai","Tiruvarur","Tonk","Tuensang","Tumkur","Udaipur","Udalguri","Udham Singh Nagar","Udhampur","Udupi","Ujjain","Ukhrul","Umaria","Una","Unnao","Upper Siang","Upper Subansiri","Uttar Dinajpur","Uttara Kannada","Uttarkashi","Vadodara","Vaishali","Valsad","Varanasi","Vellore","Vidisha","Viluppuram","Virudhunagar","Visakhapatnam","Vizianagaram","Vyara","Warangal","Wardha","Washim","Wayanad","West Champaran","West Delhi","West Garo Hills","West Kameng","West Khasi Hills","West Siang","West Sikkim","West Singhbhum","West Tripura","Wokha","Yadgir","Yamuna Nagar","Yanam","Yavatmal","Zunheboto"
    };
    DatePickerDialog.OnDateSetListener date;
    TextView tv;
    AutoCompleteTextView from;
    AutoCompleteTextView to;
      Calendar myCalendar ;
      static String bdate;
    Button but,seats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seats = findViewById(R.id.seats);
        myCalendar = Calendar.getInstance();
        but = (Button) findViewById(R.id.button);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Cities);
        from =(AutoCompleteTextView) findViewById(R.id.from);
        tv = (TextView) findViewById(R.id.textView);
        from.setAdapter(adapter);
        to = (AutoCompleteTextView) findViewById(R.id.to);
        to.setAdapter(adapter);
        seats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Booked.class);
                startActivity(intent);
            }
        });
        updateLabel();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonclick();
            }
        });
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
                hideSoftKeyboard(MainActivity.this);
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void buttonclick() {
        if(from.getText().equals("")||to.getText().equals("")||myCalendar.getTime().before(new Date()))return;
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
bdate=sdf.format(myCalendar.getTime());
        tv.setText(bdate);
    }

}
