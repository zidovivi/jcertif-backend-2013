// Fichier d'initialisation des données référentielles
db.referentiel.remove();
db.session_status.remove();
db.session_status.insert({label: 'Approuvé'});
db.session_status.insert({label: 'Brouillon'});
db.sponsor_level.remove();
db.sponsor_level.insert({label: 'Titanium'});
db.sponsor_level.insert({label: 'Platine'});
db.sponsor_level.insert({label: 'Or'});
db.sponsor_level.insert({label: 'Argent'});
db.sponsor_level.insert({label: 'Community'});
db.sponsor_level.insert({label: 'Education'});
db.sponsor_level.insert({label: 'Média'});
db.category.remove();
db.category.insert({label: 'Android'});
db.category.insert({label: 'HTML5'});
db.category.insert({label: 'Java'});
db.category.insert({label: 'Entreprise'});
db.category.insert({label: 'Web Design'});
