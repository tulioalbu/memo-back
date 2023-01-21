<script>
  import InputText from 'primevue/inputtext';

  export default {
    name: 'FormUser',
    props: {
      user: {
        type: Object,
        default: () => ({}),
      }
    },
    data() {
      return {
        form: {
          name: '',
          phone: '',
          email: '',
          avatar: '',
        },
      };
    },
    methods: {
      async postContact() {
        console.log(this.form);
        await axios.post("http://localhost:8080/contacts", {
          contactName: this.form.name,
          contactEmail: this.form.email,
          contactPhone: this.form.phone,
          contactAvatar: this.form.avatar,}
        ).then(() => {
          alert("Contato adicionado com sucesso!")
          window.location.reload();
        }, (error) => {
          alert(error.response.data);
        });
      },
    },
  };

</script>

<template>
  <div class="form">
    <span class="p-input-icon-left">
      <i class="pi pi-user" />
      <InputText v-model="form.name" id="inputs" type="text" placeholder="Nome" />
    </span>

    <span class="p-input-icon-left">
      <i class="pi pi-phone" />
      <InputText v-model="form.phone" id="inputs" type="text" placeholder="Telefone" />
    </span>
    
    <span id="input-box" class="p-input-icon-left">
      <i class="pi pi-at" />
      <InputText v-model="form.email" id="inputs" type="text" placeholder="E-mail" />
    </span>

    <span id="input-box" class="p-input-icon-left">
      <i class="pi pi-at" />
      <InputText v-model="form.avatar" id="inputs" type="text" placeholder="E-mail" />
    </span>

    <Button @click="postContact()" id="submit-button" label="Adicionar" icon="pi pi-check" class="p-button-warning p-button-raised p-button-rounded p-button-success"/>
  </div>
</template>

<style>
.form {
  display: flex;
  flex-direction: column;
  align-self: center;
  background-color: white;
  border-radius: 15px;
  margin-top: 70px;
  padding-block: 33px;
  padding-inline: 35px;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2);
  border: 3px solid black;
}
#inputs {
  letter-spacing: 1px;
  height: 45px;
  margin-block: 20px;
  width: 320px;
}
#selected {
  height: 45px;
  margin-block: 20px;
}
#submit-button {
  margin-top: 20px;
  letter-spacing: 1px;
  width: 70%;
  align-self: center;
}
</style>
