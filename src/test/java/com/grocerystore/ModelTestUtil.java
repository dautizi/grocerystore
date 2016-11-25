package com.grocerystore;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.grocerystore.model.Address;
import com.grocerystore.model.Customer;
import com.grocerystore.model.Discount;
import com.grocerystore.model.Item;
import com.grocerystore.util.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev-grocery")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public abstract class ModelTestUtil {

    private static final List<LocationEnum> LOCATIONS = Collections.unmodifiableList(Arrays.asList(LocationEnum.values()));
    public enum LocationEnum {
        MONTE_SAN_GIOVANNI("Monte San Giovanni in Sabina", "Rieti", "Italy", "02040", "Via Immaginetta 2"),
        STOCKHOLM("Stockholm", "Stockholm", "Sweden", "11420", "Birger Jarlsgatan 104 L"),
        PORTLAND("Portland", "Portland", "USA", "97232", "777 NE Martin Luther King Jr Blvd"),
        MUNICH("Munich", "Munich", "Germany", "80539", "Ludwigstraße 16"),
        TOKYO("Tokyo", "Tokyo", "Japan", "105-0012", "1 Chome-1-12-7 Shibadaimon"),
        SAN_JOSE("San José", "San José", "Costarica", "", "Calle 13"),
        TORONTO("Toronto", "Toronto", "Canada", "", "255 Front St W, Toronto, ON M5V 2W6"),
        SHANGHAI("Shanghai", "Shanghai", "China", "201200", "Chuansha, Pudong"),
        COPENHAGEN("Copenhagen", "Copenhagen", "Denmark", "1218", "Prins Jørgens Gård 1"),
        BRUGES("Bruges", "Bruges", "Belgium", "8000", "Binnenweg 4");

        private String location;
        private String province;
        private String country;
        private String postcode;
        private String address;

        private LocationEnum(String location, String province, String country,
                String postcode, String address) {
            this.location = location;
            this.province = province;
            this.country = country;
            this.postcode = postcode;
            this.address = address;
        }

        public String getLocation() {
            return location;
        }
        public String getProvince() {
            return province;
        }
        public String getCountry() {
            return country;
        }
        public String getPostcode() {
            return postcode;
        }
        public String getAddress() {
            return address;
        }
    }

    private static final List<ItemEnum> ITEMS = Collections.unmodifiableList(Arrays.asList(ItemEnum.values()));
    public enum ItemEnum {
        OLIVE_OIL("Olive Oil", "Italian Olive Oil", "olive, oil, olive oil, italian oil, italian olive oil", 1),
        FARRO("Farro", "Italian special Farro", "italian farro, farro, green, vegan, legumes", 2),
        BEAN("Bean", "Italian beans", "bean, beans, italian beans, vegan", 3),
        LEGUMES("Legumes", "Italian legumes", "legumes, italian legumes, vegan, green, healthy", 4);

        private String name;
        private String title;
        private String tag;
        private int itemImageEnumId;

        private ItemEnum(String name, String title, String tag, int itemImageEnumId) {
            this.name= name;
            this.title = title;
            this.tag = tag;
            this.itemImageEnumId = itemImageEnumId;
        }

        public String getName() {
            return name;
        }

        public String getTitle() {
            return title;
        }

        public String getTag() {
            return tag;
        }

        public int getItemImageEnumId() {
            return itemImageEnumId;
        }
    }

    private static final List<ImageEnum> IMAGES = Collections.unmodifiableList(Arrays.asList(ImageEnum.values()));
    public enum ImageEnum {
        OLIVE_OIL_IMG_1(1, "Olive Oil", "image", "/Users/danieleautizi/Pictures/grocery/olive_oil-1.jpg", "jpg", 1),
        OLIVE_OIL_IMG_2(2, "Italian Olive Oil", "image", "/Users/danieleautizi/Pictures/grocery/olive_oil-2.jpg", "jpg", 1),
        OLIVE_OIL_IMG_3(3, "Best Olive Oil", "image", "/Users/danieleautizi/Pictures/grocery/olive_oil-3.jpg", "jpg", 1),
        FARRO_IMG_1(4, "Farro", "image", "/Users/danieleautizi/Pictures/grocery/farro-1.jpg", "jpg", 1),
        FARRO_IMG_2(5, "Pure Farro", "image", "/Users/danieleautizi/Pictures/grocery/farro-2-big.jpg", "jpg", 1),
        FARRO_IMG_3(6, "Best Farro", "image", "/Users/danieleautizi/Pictures/grocery/farro-3.jpg", "jpg", 1),
        BEAN_IMG_1(7, "Bean", "image", "/Users/danieleautizi/Pictures/grocery/bean-1.jpg", "jpg", 1),
        BEAN_IMG_2(8, "Best Bean", "image", "/Users/danieleautizi/Pictures/grocery/fagioli.jpg", "jpg", 1),
        BEAN_IMG_3(9, "Beans", "image", "/Users/danieleautizi/Pictures/grocery/cereals-1.jpg", "jpg", 1),
        LEGUMES_IMG_1(10, "Legumes", "image", "/Users/danieleautizi/Pictures/grocery/lenticchie-1.jpg", "jpg", 1),
        LEGUMES_IMG_2(11, "Lenticchie", "image", "/Users/danieleautizi/Pictures/grocery/lenticchie-2.jpg", "jpg", 1),
        LEGUMES_IMG_3(12, "Best Legumes", "image", "/Users/danieleautizi/Pictures/grocery/lenticchie-4.jpg", "jpg", 1),
        LEGUMES_IMG_4(13, "Italian Legumes", "image", "/Users/danieleautizi/Pictures/grocery/lenticchie-5.jpg", "jpg", 1);

        private long id;
        private String title;
        private String mediaType;
        private String absPath;
        private String extension;
        private int status;

        private ImageEnum(long id, String title, String mediaType, String absPath, 
                String extension, int status) {
            this.id = id;
            this.title = title;
            this.mediaType = mediaType;
            this.absPath = absPath;
            this.extension = extension;
            this.status = status;
        }

        public long getId() {
            return id;
        }
        public String getTitle() {
            return title;
        }
        public String getMediaType() {
            return mediaType;
        }
        public String getAbsPath() {
            return absPath;
        }
        public String getExtension() {
            return extension;
        }
        public int getStatus() {
            return status;
        }
    }

    private static final List<ItemImageEnum> ITEM_IMAGES = Collections.unmodifiableList(Arrays.asList(ItemImageEnum.values()));
    public enum ItemImageEnum {
        OLIVE_OIL_1(1, 1, "Olive Oil", "Italian Olive Oil", "", "image", "", "http://grocery.local/images/items/olive_oil-1.jpg", 1, 1),
        OLIVE_OIL_2(1, 2, "Italian Olive Oil", "Italian Olive Oil", "", "image", "", "http://grocery.local/images/items/olive_oil-2.jpg", 2, 1),
        OLIVE_OIL_3(1, 3, "Best Olive Oil", "Best Italian Olive Oil", "", "image", "", "http://grocery.local/images/items/olive_oil-3.jpg", 3, 1),
        FARRO_1(2, 4, "Farro", "Italian special Farro", "", "image", "", "http://grocery.local/images/items/farro-1.jpg", 1, 1),
        FARRO_2(2, 5, "Pure Farro", "Pure Italian special Farro", "", "image", "", "http://grocery.local/images/items/farro-2-big.jpg", 2, 1),
        FARRO_3(2, 6, "Best Farro", "Best Italian special Farro", "", "image", "", "http://grocery.local/images/items/farro-3.jpg", 3, 1),
        BEAN_1(3, 7, "Bean", "Italian beans", "", "image", "", "http://grocery.local/images/items/bean-1.jpg", 1, 1),
        BEAN_2(3, 8, "Best Bean", "Italian tasty beans", "", "image", "", "http://grocery.local/images/items/fagioli.jpg", 2, 1),
        BEAN_3(3, 9, "Beans", "Italian beans", "", "image", "", "http://grocery.local/images/items/cereals-1.jpg", 3, 1),
        LEGUMES_1(4, 10, "Legumes", "Italian legumes", "", "image", "", "http://grocery.local/images/items/lenticchie-1.jpg", 1, 1),
        LEGUMES_2(4, 11, "Lenticchie", "Italian Lenticchie legumes", "", "image", "", "http://grocery.local/images/items/lenticchie-2.jpg", 2, 1),
        LEGUMES_3(4, 12, "Best Legumes", "Best Italian legumes", "", "image", "", "http://grocery.local/images/items/lenticchie-4.jpg", 3, 1),
        LEGUMES_4(4, 13, "Italian Legumes", "Italian tasty legumes", "", "image", "", "http://grocery.local/images/items/lenticchie-5.jpg", 4, 1);

        private int group;
        private int idImage;
        private String title;
        private String alt;
        private String cssClass;
        private String mediaType;
        private String mediaPath;
        private String mediaUrl;
        private int prg;
        private int status;

        private ItemImageEnum(int group, int idImage, String title, String alt, String cssClass,
                String mediaType, String mediaPath, String mediaUrl, int prg, int status) {
            this.group = group;
            this.idImage = idImage;
            this.title = title;
            this.alt = alt;
            this.cssClass = cssClass;
            this.mediaType = mediaType;
            this.mediaPath = mediaPath;
            this.mediaUrl = mediaUrl;
            this.prg = prg;
            this.status = status;
        }

        public int getGroup() {
            return group;
        }
        public int getIdImage() {
            return idImage;
        }
        public String getTitle() {
            return title;
        }
        public String getAlt() {
            return alt;
        }
        public String getCssClass() {
            return cssClass;
        }
        public String getMediaType() {
            return mediaType;
        }
        public String getMediaPath() {
            return mediaPath;
        }
        public String getMediaUrl() {
            return mediaUrl;
        }
        public int getPrg() {
            return prg;
        }
        public int getStatus() {
            return status;
        }

        public Set<ItemImageEnum> getItemImagesByGroupId(int idGroup) {
            Set<ItemImageEnum> itemImages = new HashSet<ItemImageEnum>();
            for (ItemImageEnum iie : ItemImageEnum.values()) {
                if (idGroup == iie.getGroup()) {
                    itemImages.add(iie);
                }
            }
            return itemImages;
        }
    }

    /* TODO
    private static final List<DiscountEnum> DISCOUNTS = Collections.unmodifiableList(Arrays.asList(DiscountEnum.values()));
    public enum DiscountEnum {
        PERC_10("Olive Oil", "Italian Olive Oil", "", DateUtil.getTimestampNow(), 10, 1),
        PERC_15("Farro", "Italian special Farro", "", DateUtil.getTimestampNow(), 15, 1),
        PERC_20("Bean", "Italian beans", "", DateUtil.getTimestampNow(), 20, 1),
        PERC_25("Legumes", "Italian legumes", "", DateUtil.getTimestampNow(), 25, 1);

        private String name;
        private String description;
        private String cover;
        private Timestamp from;
        private int percentage;
        private Timestamp to;
        private BigDecimal minMoney;
        private BigDecimal maxSavedMoney;
        private int status;

        private DiscountEnum(String name, String description, String cover,
                Timestamp from, int percentage, Timestamp to, BigDecimal minMoney, 
                BigDecimal maxSavedMoney, int status) {
            this.name = name;
            this.description = description;
            this.cover = cover;
            this.from = from;
            this.percentage = percentage;
            this.to = to;
            this.minMoney = minMoney;
            this.maxSavedMoney = maxSavedMoney;
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getCover() {
            return cover;
        }

        public Timestamp getFrom() {
            return from;
        }

        public int getPercentage() {
            return percentage;
        }

        public Timestamp getTo() {
            return to;
        }

        public BigDecimal getMinMoney() {
            return minMoney;
        }

        public BigDecimal getMaxSavedMoney() {
            return maxSavedMoney;
        }

        public int getStatus() {
            return status;
        }
    }
    */

    public Address getNewAddress(long idCustomer, boolean defaultAdress, boolean sameAddress, int status) {
        LocationEnum locationEnum = getRandomLocationEnum();
        Address address = new Address();
        address.setAddress1(locationEnum.getAddress());
        address.setAddressType(1);
        address.setCountry(locationEnum.getCountry());
        address.setCustomerDefault(defaultAdress);
        address.setIdCustomer(idCustomer);
        address.setLocality(locationEnum.getLocation());
        address.setPostcode(locationEnum.getPostcode());
        address.setPrg(1);
        address.setProvince(locationEnum.getPostcode());
        address.setSameAddress(sameAddress);
        address.setStatus(status);
        return address;
    }

    public Customer getNewCustomer() {
        LocationEnum locationEnum = getRandomLocationEnum();
        Customer customer = new Customer();
        customer.setEmail(getEmail());
        customer.setBirthCountry(locationEnum.getCountry());
        customer.setBirthLocation(locationEnum.getLocation());
        customer.setBirthmonth(getRandomMonth());
        customer.setBirthday(getRandomDay());
        customer.setBirthyear(getRandomYear());
        customer.setCountry(locationEnum.getCountry());
        customer.setEmailVerification(true);
        customer.setName(getName());
        customer.setPassword(getRandomPassword());
        customer.setSurname(getSurname());
        customer.setStatus(getActiveStatus());
        customer.setUsername(getUsername());
        customer.setVisits(0);
        customer.setAge(getAge(customer));

        return customer;
    }

    /*
    public Item getNewItem() {
        LocationEnum locationEnum = getRandomLocationEnum();
        ItemEnum itemEnum = getRandomItemEnum();
        ItemImageEnum itemImageEnum = getRandomItemImageEnum();
        DiscountEnum discountEnum = getRandomDiscountEnum();
        
        
        Item item = new Item();
        item.setAvailability(getRandomAvailability());
        item.setCover(getRandomItemImage());
        item.setDiscount();
        item.setDiscountFrom();
        item.setDiscountFromFormat(discountFromFormat);
        item.setDiscountPercentage(discountPercentage);
        item.setDiscountPrice(discountPrice);
        item.setDiscountPrice(discountPrice);
        item.setDiscountTo(discountTo);
        item.setDiscountToFormat(discountToFormat);
        item.setFullPrice(fullPrice);
        item.setImages();
        item.setName(name);
        item.setNextAvailability(nextAvailability);
        item.setNextAvailabilityFormat(nextAvailabilityFormat);
        item.setNutritionalImage(nutritionalImage);
        item.setStatus(getActiveStatus());
        item.setTag(tag);
        item.setTitle(title);

        return item;
    }
    */

    public int getAge(Customer customer) {
        int age = 0;
        if (customer != null) {
            int day = customer.getBirthday();
            int month = customer.getBirthmonth();
            int year = customer.getBirthyear();
            LocalDate birthdate = new LocalDate(year, month, day);
            LocalDate now = new LocalDate();
            Years years = Years.yearsBetween(birthdate, now);
            age = years.getYears();
        }
        return age;
    }

    public int getActiveStatus() {
        return 1;
    }

    public int getDisactiveStatus() {
        return 0;
    }

    public int getRandomAvailability() {
        int min = 0;
        int max = 100;
        return getRandomIntInARange(min, max);
    }

    public int getRandomDay() {
        int min = 1;
        int max = 28;
        return getRandomIntInARange(min, max);
    }

    public int getRandomMonth() {
        int min = 1;
        int max = 12;
        return getRandomIntInARange(min, max);
    }

    public int getRandomYear() {
        int min = 1920;
        int max = 2000;
        return getRandomIntInARange(min, max);
    }

    public int getRandomIntInARange(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public LocationEnum getRandomLocationEnum() {
        int index = new Random().nextInt(LOCATIONS.size());
        LocationEnum locationEnum = LOCATIONS.get(index);
        return locationEnum;
    }

    public ItemEnum getRandomItemEnum() {
        int index = new Random().nextInt(ITEMS.size());
        ItemEnum itemEnum = ITEMS.get(index);
        return itemEnum;
    }

    public String getRandomProvince() {
        String location = "";
        List<String> locations = new ArrayList<String>();
        locations.add("Monte San Giovanni in Sabina");
        locations.add("Stockholm");
        locations.add("Portland");
        locations.add("Munich");
        locations.add("Tokyo");
        locations.add("San José");
        locations.add("Toronto");
        locations.add("Shanghai");
        locations.add("Copenhagen");
        locations.add("Bruges");
        int index = new Random().nextInt(locations.size());
        location = locations.get(index);
        return location;
    }

    public String getRandomLocation() {
        String location = "";
        List<String> locations = new ArrayList<String>();
        locations.add("Monte San Giovanni in Sabina");
        locations.add("Stockholm");
        locations.add("Portland");
        locations.add("Munich");
        locations.add("Tokyo");
        locations.add("San José");
        locations.add("Toronto");
        locations.add("Shanghai");
        locations.add("Copenhagen");
        locations.add("Bruges");
        int index = new Random().nextInt(locations.size());
        location = locations.get(index);
        return location;
    }

    public String getRandomCountry() {
        String country = "";
        List<String> countries = new ArrayList<String>();
        countries.add("Italy");
        countries.add("Sweden");
        countries.add("USA");
        countries.add("Germany");
        countries.add("Japan");
        countries.add("Costarica");
        countries.add("Canada");
        countries.add("China");
        countries.add("Denmark");
        countries.add("Belgium");
        int index = new Random().nextInt(countries.size());
        country = countries.get(index);
        return country;
    }

    public String getUsername() {
        String username = "";
        Date now = new Date();
        username = "skav_" + now.getTime();
        return username;
    }

    public String getName() {
        String name = "Lorem";
        name += getRandomChar();
        return name;
    }

    public String getSurname() {
        String surname = "Anyfazium";
        surname += getRandomChar();
        return surname;
    }

    public String getEmail() {
        return getEmail(null);
    }

    public String getEmail(String host) {
        String email = "testEmail_";
        if (StringUtils.isEmpty(host)) {
            host = "test.com";
        }
        Date now = new Date();
        email += String.valueOf(now.getTime()) + "@" + host;
        return email;
    }

    private char getRandomChar() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int i = new Random().nextInt(chars.length);
        return chars[i];
    }

    public String getRandomPassword() {
        String password = "Default.11";
        int noOfCAPSAlpha = 1;
        int noOfDigits = 1;
        int noOfSplChars = 1;
        int minLen = 8;
        int maxLen = 10;

        try {
            char[] passwordInChars = generatePswd(minLen, maxLen, noOfCAPSAlpha, noOfDigits, noOfSplChars);
            password = String.valueOf(passwordInChars);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return password;
    }

    private char[] generatePswd(int minLen, int maxLen, int noOfCAPSAlpha, int noOfDigits, int noOfSplChars) {
        String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ALPHA = "abcdefghijklmnopqrstuvwxyz";
        String NUM = "0123456789";
        String SPL_CHARS = "._-";
        
        if (minLen > maxLen) {
            throw new IllegalArgumentException("Min. Length > Max. Length!");
        }

        if ((noOfCAPSAlpha + noOfDigits + noOfSplChars) > minLen) {
            throw new IllegalArgumentException("Min. Length should be atleast sum of (CAPS, DIGITS, SPL CHARS) Length!");
        }

        Random rnd = new Random();
        int len = rnd.nextInt(maxLen - minLen + 1) + minLen;
        char[] pswd = new char[len];
        int index = 0;
        for (int i = 0; i < noOfCAPSAlpha; i++) {
            index = getNextIndex(rnd, len, pswd);
            pswd[index] = ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length()));
        }
        for (int i = 0; i < noOfDigits; i++) {
            index = getNextIndex(rnd, len, pswd);
            pswd[index] = NUM.charAt(rnd.nextInt(NUM.length()));
        }
        for (int i = 0; i < noOfSplChars; i++) {
            index = getNextIndex(rnd, len, pswd);
            pswd[index] = SPL_CHARS.charAt(rnd.nextInt(SPL_CHARS.length()));
        }
        for(int i = 0; i < len; i++) {
            if(pswd[i] == 0) {
                pswd[i] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
            }
        }
        return pswd;
    }

    private int getNextIndex(Random rnd, int len, char[] pswd) {
        int index = rnd.nextInt(len);
        while(pswd[index = rnd.nextInt(len)] != 0);
        return index;
    }

}
