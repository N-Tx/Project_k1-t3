// Estado da aplicação
let tasks = [];
let editingId = null;

// Captura de elementos do DOM
const form = document.getElementById('task-form');
const titleInput = document.getElementById('title');
const descInput = document.getElementById('description');
const statusInput = document.getElementById('status');

const priorityInput = document.getElementById('priority'); // 
const categoryInput = document.getElementById('category'); // 

const submitBtn = document.getElementById('submit-btn');
const cancelBtn = document.getElementById('cancel-btn');
const formTitle = document.getElementById('form-title');
const taskList = document.getElementById('task-list');
const filterStatus = document.getElementById('filter-status');

const filterPriority = document.getElementById('filter-priority'); 
const filterCategory = document.getElementById('filter-category'); 

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
        tasks.unshift(newTask);
    }

    resetForm();
    renderTasks(); 
}

// Preparar formulário para edição
function editTask(id) {
    const task = tasks.find(t => t.id === id);
    if (!task) return;

    // Preenche o formulário com os dados da tarefa selecionada
    titleInput.value = task.title;
    descInput.value = task.description;
    statusInput.value = task.status;
    
    editingId = id;
    
    // Altera o visual do formulário
    formTitle.textContent = 'Editando Tarefa';
    submitBtn.textContent = 'Atualizar Tarefa';
    cancelBtn.classList.remove('hidden');
}

// (D) - Excluir Tarefa
function deleteTask(id) {
    if(confirm('Tem certeza que deseja excluir esta tarefa?')) {
        tasks = tasks.filter(t => t.id !== id);
        renderTasks();
    }
}

// Restaura o formulário para o estado de criação
function resetForm() {
    form.reset();
    editingId = null;
    formTitle.textContent = 'Nova Tarefa';
    submitBtn.textContent = 'Salvar Tarefa';
    cancelBtn.classList.add('hidden');
}

// (R) - Renderizar as tarefas (com filtro opcional aplicado)
function renderTasks() {
    taskList.innerHTML = '';
    const filterValue = filterStatus.value;

    const filteredTasks = filterValue === 'ALL' 
        ? tasks 
        : tasks.filter(t => t.status === filterValue);

    filteredTasks.forEach(task => {
        const li = document.createElement('li');
        li.className = `task-item ${task.status.toLowerCase()}`;
        
        li.innerHTML = `
            <div class="task-content">
                <h3>${task.title}</h3>
                <p>${task.description}</p>
                <span class="task-status">[${task.status}]</span>
            </div>
            <div class="task-actions">
                <button class="edit-btn" onclick="editTask(${task.id})">Editar</button>
                <button class="delete-btn" onclick="deleteTask(${task.id})">Excluir</button>
            </div>
        `;
        
        taskList.appendChild(li);
    });
}

// Renderização inicial
renderTasks();