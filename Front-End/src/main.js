import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import PrimeVue from 'primevue/config';

import Header from './components/Header.vue';
import FormUser from './components/FormUser.vue';
import UpdateUser from './components/UpdateUser.vue';
import Card from './components/Card.vue';

import InputText from 'primevue/inputtext'
import AutoComplete from 'primevue/autocomplete';
import Button from 'primevue/button';

import 'primevue/resources/themes/saga-orange/theme.css';    
import 'primevue/resources/primevue.min.css';
import 'primeicons/primeicons.css' 

const Application = createApp(App)

Application.use(PrimeVue)

Application.component('Button', Button)
Application.component('InputText', InputText)
Application.component('AutoComplete', AutoComplete)

Application.component('Header', Header)
Application.component('FormUser', FormUser)
Application.component('UpdateUser', UpdateUser)
Application.component('Card', Card)

Application.mount('#app')
