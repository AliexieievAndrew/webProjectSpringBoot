    package com.example.webshop.dto;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import org.hibernate.annotations.Type;
    import org.hibernate.validator.constraints.NotBlank;
    import org.springframework.web.multipart.MultipartFile;

    import javax.persistence.*;
    import javax.validation.constraints.Min;
    import java.util.UUID;

    @Entity
    @Table(name="product")
    public class Product {

        // for uploading file
        // will be cleared at the end of request processing
        @Transient // - temporary
        private MultipartFile file;

        // returning abstraction of the file
        @JsonIgnore
        public MultipartFile getFile() {
            return file;
        }

        public void setFile(MultipartFile file) {
            this.file = file;
        }

        public Product() {
            this.code = "PROD" + UUID.randomUUID().toString().substring(26).toUpperCase();
        }

        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name="code")
        private String code;

        @Column(name = "name")
        @NotBlank(message = "please enter the Product name")
        private String name;

        @Column(name = "description")
        @NotBlank(message = "please enter the description for Product ")
        private String description;

        @Column(name = "unit_price")
        @Min(value = 1, message = "value can not be less than 1")
        private double unitPrice;

        @Column(name = "is_active")
        @Type(type = "org.hibernate.type.NumericBooleanType")
        private boolean active = true;

        @Column(name = "category_id")
        private int categoryId;

        @Column(name = "purchases")
        private int purchases;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getPurchases() {
            return purchases;
        }

        public void setPurchases(int purchases) {
            this.purchases = purchases;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", unitPrice=" + unitPrice +
                    ", active=" + active +
                    ", categoryId=" + categoryId +
                    ", purchases=" + purchases +
                    '}';
        }
    }
