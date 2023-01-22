<script> 
  import InputText from 'primevue/inputtext';

  export default {
    name: 'UpdateUser',
    props: {
      userId: String,
      userName: String,
      userPhone: String,
      userEmail: String,
      userAvatar: String,
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
      async updateContact(id) {
        console.log(this.form);
        await axios.put(`http://localhost:8080/contacts/${id}`, {
          contactName: this.form.name,
          contactEmail: this.form.email,
          contactPhone: this.form.phone,
          contactAvatar: this.form.avatar,}
        ).then(() => {
          alert("Contato modificado com sucesso!")
          window.location.reload();
        }, (error) => {
          alert(error.response.data);
        });
      },
      closeWindow() {
        window.location.reload();
      }
    },
  };

</script>

<template>
  <div class="form">
    
    <i @click="closeWindow()" id="closeWindow" class="pi pi-times" />

    <span class="p-input-icon-left">
      <i class="pi pi-user" />
      <InputText v-model="form.name" bind:value="userName" id="inputs" type="text" placeholder="Nome" />
    </span>

    <span class="p-input-icon-left">
      <i class="pi pi-phone" />
      <InputText v-model="form.phone" bind:value="userPhone" id="inputs" type="text" placeholder="Telefone" />
    </span>
    
    <span id="input-box" class="p-input-icon-left">
      <i class="pi pi-at" />
      <InputText v-model="form.email" bind:value="userEmail" id="inputs" type="text" placeholder="E-mail" />
    </span>

    <span id="input-box" class="p-input-icon-left">
      <i class="pi pi-at" />
      <InputText v-model="form.avatar" bind:value="userAvatar" id="inputs" type="text" placeholder="E-mail" />
    </span>

    <Button @click="updateContact(userId)" id="submit-button" label="Modificar" icon="pi pi-check" class="p-button-warning p-button-raised p-button-rounded p-button-success"/>
  </div>
</template>

<style>
.form {
  display: flex;
  flex-direction: column;
  align-self: center;
  background-image: url('path/to/image.jpg');
  border-radius: 15px;
  margin-top: 70px;
  padding-block: 33px;
  padding-inline: 35px;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2);
  border: 3px solid black;

}
.bg {

background-image: url("./assets/FUNDO2.png");
background-repeat: cover;
z-index: 1;
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
#closeWindow {
  position: absolute;
  transform: scale(1.5);
  right: 0;
  top: 0;
  margin: 20px;
  cursor: pointer;
}
</style>
