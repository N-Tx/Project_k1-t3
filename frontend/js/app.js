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

// Event Listeners
form.addEventListener('submit', handleFormSubmit);
cancelBtn.addEventListener('click', resetForm);
filterStatus.addEventListener('change', renderTasks);

// (C) e (U) - Criar ou Atualizar Tarefa
function handleFormSubmit(e) {
    e.preventDefault();

    const taskData = {
        title: titleInput.value,
        description: descInput.value,
        status: statusInput.value
    };

    if (editingId) {
        // Atualiza a tarefa existente
        const index = tasks.findIndex(t => t.id === editingId);
        if (index !== -1) {
            tasks[index] = { ...tasks[index], ...taskData };
        }
    } else {
        // Cria nova tarefa com ID único baseado no timestamp
        const newTask = { id: Date.now(), ...taskData };
        tasks.push(newTask);
    }

    resetForm();
    renderTasks(); 
}