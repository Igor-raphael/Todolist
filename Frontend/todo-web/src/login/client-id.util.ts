export function getClientId(): string {
  const key = 'todo_client_id';

  let clientId = localStorage.getItem(key);

  if(!clientId){
    clientId = crypto.randomUUID();
    localStorage.setItem(key, clientId)
  }

  return clientId;
}
