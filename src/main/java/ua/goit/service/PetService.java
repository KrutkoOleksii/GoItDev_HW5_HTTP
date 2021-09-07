package ua.goit.service;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import ua.goit.model.Category;
import ua.goit.model.Pet;
import ua.goit.model.Tag;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.PetRepository;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

import java.util.Scanner;

public class PetService {

    private final BaseRepository petRepository = new PetRepository();
    private final Scanner scanner = new Scanner(System.in);
    private final RetrofitClient retrofitClient = BaseConnect.getClient();

    public Pet createNewPet() {
        Pet newPet = (Pet) petRepository.createEntity(inputNewPet());
        return newPet;
    }

    public Pet updatePet() {
        Pet newPet = (Pet) petRepository.updateEntity(inputNewPet());
        return newPet;
    }

    public ResponseBody getPetsByStatus(){
        System.out.println("please enter the statuses of pets separated by commas:\n {status1},{status2}, ... {statusN}");
        String stringStatuses = scanner.next();
        String[] statuses = stringStatuses.split(",");
        return RetrofitConfig.execute(retrofitClient.getPetByStatus(statuses));
    }

    public Pet updatePetById() {
        System.out.println("please enter id, new name and new status of pet separated by commas:\n {id},{new name}, {new status}");
        String paramsPet = scanner.next();
        String[] split = paramsPet.split(",");
        RequestBody namePet = RequestBody.create(MediaType.parse("string"), split[1]);
        RequestBody status = RequestBody.create(MediaType.parse("string"),  split[2]);
        return RetrofitConfig.execute(retrofitClient.updatePetById(Integer.valueOf(split[0]), namePet, status));
    }

    public Pet getPet() {
        System.out.println("please enter id:");
        String id = scanner.next();
        return (Pet) petRepository.getEntity(id);
    }

    public void deletePet() {
        System.out.println("please enter id:");
        String id = scanner.next();
        ResponseBody responseBody = petRepository.deleteEntity(id);
    }

    public Pet inputNewPet(){
        System.out.println("please input parameters of pet separated by commas:\n {id},{name},{status},{category name},{tag}");
        String paramsPet = scanner.next();
        String[] split = paramsPet.split(",");
        return Pet.builder()
                .id(Integer.valueOf(split[0]))
                .name(split[1])
                .status(split[2])
                .category(new Category(0, split[3]))
                .tags(new Tag[]{new Tag(0, split[4])})
                .build();
    }


}
