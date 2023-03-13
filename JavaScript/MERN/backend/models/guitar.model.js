const mongoose = require('mongoose');

const schema = mongoose.Schema;

const gtrSchema = new schema({
  guitarid: { type: String , default:""},
  g_type: {type:String, default:""},
  quantity:{type: Number, default:0},
  price: { type: Number, default:0},
  
}, {
  timestamps: true,
});

const gtr = mongoose.model('gtr', gtrSchema);

module.exports = gtr;