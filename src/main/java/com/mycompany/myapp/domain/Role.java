package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Role.
 */
@Entity
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "role", nullable = false)
    private String role;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "roles", "donVi" }, allowSetters = true)
    private Set<NhanVien> nhanViens = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role id(Long id) {
        this.id = id;
        return this;
    }

    public String getRole() {
        return this.role;
    }

    public Role role(String role) {
        this.role = role;
        return this;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<NhanVien> getNhanViens() {
        return this.nhanViens;
    }

    public Role nhanViens(Set<NhanVien> nhanViens) {
        this.setNhanViens(nhanViens);
        return this;
    }

    public Role addNhanVien(NhanVien nhanVien) {
        this.nhanViens.add(nhanVien);
        nhanVien.getRoles().add(this);
        return this;
    }

    public Role removeNhanVien(NhanVien nhanVien) {
        this.nhanViens.remove(nhanVien);
        nhanVien.getRoles().remove(this);
        return this;
    }

    public void setNhanViens(Set<NhanVien> nhanViens) {
        if (this.nhanViens != null) {
            this.nhanViens.forEach(i -> i.removeRole(this));
        }
        if (nhanViens != null) {
            nhanViens.forEach(i -> i.addRole(this));
        }
        this.nhanViens = nhanViens;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        return id != null && id.equals(((Role) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Role{" +
            "id=" + getId() +
            ", role='" + getRole() + "'" +
            "}";
    }
}
