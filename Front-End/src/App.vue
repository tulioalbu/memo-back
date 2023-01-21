<script>
  import axios from "axios";

  export default {
  name: "App",
    data() {
      return {
        contacts: [],
      };
    },
    methods: {
      async getContacts() {
        await axios.get("http://localhost:8080/contacts").then((response) => {
          console.log(response.data)
          this.contacts = response.data;
        });
      },
    },
    mounted() {
      this.getContacts();
    },
  };

</script>

<template>
  <div id="cols" class="bg">
    <div class="col-a">
      <Header/>
      <FormUser/>
    </div>

  <div class="contact-cards">
    <div v-for="contact in contacts.reverse()" v-bind:key="contact.contactId" >
      <Card 
        :cardName="`${contact.contactName}`" 
        :cardPhone="`${contact.contactPhone}`" 
        :cardEmail="`${contact.contactEmail}`"
        :cardAvatar="`${contact.contactAvatar}`"
        :cardId="`${contact.contactId}`"
      />
    </div>
  </div>

  </div>
</template>

<style>
  #cols {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-block: 30px;
    margin-inline: 80px;
  }
  .col-a {
    display: flex;
    flex-direction: column;
  }
  .contact-cards {

    display: flex;
    flex-direction: column;
    justify-content: center;
  } 
  .bg {

    background-image: url("./assets/FUNDO2.png");
    background-repeat: cover;
    z-index: 1;
  }
</style>
