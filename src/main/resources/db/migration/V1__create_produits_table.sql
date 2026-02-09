CREATE TABLE produits (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(200) NOT NULL,
    categorie VARCHAR(20) NOT NULL,
    quantite INTEGER NOT NULL DEFAULT 1,
    date_achat DATE NOT NULL,
    date_expiration DATE NOT NULL,
    notes TEXT,
    photo_path VARCHAR(500),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    CONSTRAINT chk_quantite CHECK ( quantite > 0 )
);

CREATE INDEX idx_produits_date_expiration ON produits(date_expiration);
CREATE INDEX idx_produits_categorie ON produits(categorie);