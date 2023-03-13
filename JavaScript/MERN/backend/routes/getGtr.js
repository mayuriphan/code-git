const router = require('express').Router();
let gtr = require('../models/guitar.model');

router.route('/').get((req, res) => {
  gtr.find()
    .then(getGtr => res.json(getGtr))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/check').get((req, res) => {
  // req.query.guitarid
  gtr.find({"guitarid":req.query.guitarid})
    .then(getGtr => res.json(getGtr))
    .catch(err => res.status(400).json('Error: ' + err));
  });

router.route('/insert').post((req, res) => {
    const guitarid = req.body.guitarid;
    const g_type = req.body.g_type;
    const price = Number(req.body.price);
    const quantity = Number(req.body.quantity);  
    const gtrData = new gtr({
        guitarid,
        g_type,
        price,
        quantity,
        
    });
    
    gtrData.save()
    .then(() => res.json('Guitars added!'))
    .catch(err => res.status(400).json('Error: ' + err));
    });
module.exports = router;