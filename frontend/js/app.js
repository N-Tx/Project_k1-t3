// Estado da aplicação
let tasks = [];
let editingId = null;

// Captura de elementos do DOM
const form = document.getElementById('task-form');
const titleInput = document.getElementById('title');
const descInput = document.getElementById('description');
const statusInput = document.getElementById('status');
const submitBtn = document.getElementById('submit-btn');
const cancelBtn = document.getElementById('cancel-btn');
const formTitle = document.getElementById('form-title');
const taskList = document.getElementById('task-list');
const filterStatus = document.getElementById('filter-status');