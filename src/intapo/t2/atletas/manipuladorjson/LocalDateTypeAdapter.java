package intapo.t2.atletas.manipuladorjson;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateTypeAdapter implements JsonDeserializer<LocalDate>, JsonSerializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonElement src, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		LocalDate data = LocalDate.parse(src.getAsString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return data;
	}

	@Override
	public JsonElement serialize(LocalDate data, Type type, JsonSerializationContext context) {
		String dataString = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		JsonElement string = new JsonPrimitive(dataString);
		return string;
	}

}
