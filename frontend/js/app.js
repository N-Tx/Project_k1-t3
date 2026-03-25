
let tasks = [];
let editingId = null;

const form = document.getElementById('task-form');
const titleInput = document.getElementById('title');
const descInput = document.getElementById('description');
const statusInput = document.getElementById('status');

const priorityInput = document.getElementById('priority');
const categoryInput = document.getElementById('category'); 
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

filterPriority.addEventListener('change', renderTasks); 
filterCategory.addEventListener('change', renderTasks); 

// aqui estou criando e att tarefas
function handleFormSubmit(e) {
    e.preventDefault();

    const taskData = {

    title: titleInput.value,
    description: descInput.value,
    status: statusInput.value,

    priority: priorityInput.value, 
    category: categoryInput.value  

};

    if (editingId) {
        
        const index = tasks.findIndex(t => t.id === editingId); // retorna a posição do objeto q quer
        if (index !== -1) {
            tasks[index] = { ...tasks[index], ...taskData };
        }
    } else {
        // cria nova tarefa com ID único como um primarykey
        const newTask = { id: Date.now(), ...taskData };
        tasks.unshift(newTask);
    }

    resetForm();
    renderTasks(); 
}

function editTask(id) {
    const task = tasks.find(t => t.id === id);
    if (!task) return;

    
    titleInput.value = task.title;
    descInput.value = task.description;
    statusInput.value = task.status;
    
    priorityInput.value = task.priority; 
    categoryInput.value = task.category; 
    
    editingId = id;
    
    formTitle.textContent = 'Editando Tarefa';
    submitBtn.textContent = 'Atualizar Tarefa';
    cancelBtn.classList.remove('hidden');
}


function deleteTask(id) {
    if(confirm('Tem certeza que deseja excluir esta tarefa?')) {
        tasks = tasks.filter(t => t.id !== id);
        renderTasks();
    }
}

function resetForm() {
    form.reset();
    editingId = null;
    formTitle.textContent = 'Nova Tarefa';
    submitBtn.textContent = 'Salvar Tarefa';
    cancelBtn.classList.add('hidden');
}

function renderTasks(){

taskList.innerHTML = '';

const statusFilter = filterStatus.value;
const priorityFilter = filterPriority.value; 
const categoryFilter = filterCategory.value; 


const filteredTasks = tasks.filter(task =>{

const statusMatch =
statusFilter === 'ALL' || task.status === statusFilter;

const priorityMatch =
priorityFilter === 'ALL' || task.priority === priorityFilter; 

const categoryMatch =
categoryFilter === 'ALL' || task.category === categoryFilter; 

return statusMatch && priorityMatch && categoryMatch;

});


filteredTasks.forEach(task =>{

const li = document.createElement('li');

li.className = `task-item ${task.status.toLowerCase()}`;

li.innerHTML = `

<div>

<h3>${task.title}</h3>

<p>${task.description}</p>

<span class="task-status">

[${task.status}] | Prioridade: ${task.priority} | Categoria: ${task.category}

</span>

</div>

<div class="task-actions">

<button class="edit-btn" onclick="editTask(${task.id})">Editar</button>

<button class="delete-btn" onclick="deleteTask(${task.id})">Excluir</button>

</div>

`;

taskList.appendChild(li);

});

}

renderTasks();