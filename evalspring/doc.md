# Documentation Evalspring

## Ajouter un produit :
* **Méthode** : `POST`
* **URL** : `http://localhost:8080/produit`

**Exemple de JSON valide:**
```json
{
    "nom":"didgeridoo",
    "prix":850.50,
    "categorie": {
        "id": 1
        }
}
```
**Exemple de JSON non valide:**
```json
{
    "nom": "Ukulele",
    "prix": -10.0,
    "categorie": {
        "id": 1
    }
}
```
## Afficher tous les produits:
* **Méthode** : `GET`
* **URL** : `http://localhost:8080/produits`

## Afficher une catégorie par son ID :
* **Méthode** : `GET`
* **URL** : `http://localhost:8080/categorie/1`