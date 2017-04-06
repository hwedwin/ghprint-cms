package com.ghprint.cms.model.stock;

public class TMaterialStock {
    private Integer id;

    private String provider;

    private String name;

    private String specification;

    private Float ply;

    private String portrait;

    private Integer infeed;

    private Integer packages;

    private Float price=0f;

    private Float amount=0f;

    private Float materialsum=0f;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public Float getPly() {
        return ply;
    }

    public void setPly(Float ply) {
        this.ply = ply;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    public Integer getInfeed() {
        return infeed;
    }

    public void setInfeed(Integer infeed) {
        this.infeed = infeed;
    }

    public Integer getPackages() {
        return packages;
    }

    public void setPackages(Integer packages) {
        this.packages = packages;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getMaterialsum() {
        return materialsum;
    }

    public void setMaterialsum(Float materialsum) {
        this.materialsum = materialsum;
    }

    public TMaterialStock() {
    }

    public TMaterialStock(String provider, String name, String specification, Float ply, String portrait, Integer infeed, Integer packages, Float price, Float amount, Float materialsum) {
        this.provider = provider;
        this.name = name;
        this.specification = specification;
        this.ply = ply;
        this.portrait = portrait;
        this.infeed = infeed;
        this.packages = packages;
        this.price = price;
        this.amount = amount;
        this.materialsum = materialsum;
    }

    @Override
    public String toString() {
        return "TMaterialStock{" +
                "id=" + id +
                ", provider='" + provider + '\'' +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", ply=" + ply +
                ", portrait='" + portrait + '\'' +
                ", infeed=" + infeed +
                ", packages=" + packages +
                ", price=" + price +
                ", amount=" + amount +
                ", materialsum=" + materialsum +
                '}';
    }
}